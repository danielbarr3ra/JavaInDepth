package com.semanticsquare.thirllio.bgjobs;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.semanticsquare.thirllio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.WebLink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

public class WebpageDownloaderTask implements Runnable {

	private static BookmarkDao dao = new BookmarkDao();

	private static final long TIME_FRAME = 3000000000L;

	private boolean downloadAll = false;

	ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);

	private static class Downloader<T extends WebLink> implements Callable<T> {
		private T weblink;

		public Downloader(T weblink) {
			this.weblink = weblink;
		}

		public T call() {
			try {
				if (!weblink.getUrl().endsWith(".pdf")) {
					weblink.setDownloadStatus(WebLink.DownloadStatus.FAILED);
					String htmlPage = HttpConnect.download(weblink.getUrl());
					weblink.setHtmlPage(htmlPage);
				} else {
					weblink.setDownloadStatus(WebLink.DownloadStatus.NOT_ELIGIBLE);

				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return weblink;
		}
	}

	public WebpageDownloaderTask(boolean downloadAll) {
		this.downloadAll = downloadAll;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted()) {
			// get
			List<WebLink> webLinks = getWebLinks();
			// download
			if (webLinks.size() > 0) {
				download(webLinks);
			} else {
				System.out.println("no new web links to download");
			}
			// wait
			try {
				TimeUnit.SECONDS.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		downloadExecutor.shutdown();
	}

	private void download(List<WebLink> webLinks) {
		// TODO Auto-generated method stub
		List<Downloader<WebLink>> tasks = getTasks(webLinks);
		List<Future<WebLink>> futures = new ArrayList<>();
				
		try {
			futures = downloadExecutor.invokeAll(tasks, TIME_FRAME, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Future<WebLink> future : futures) {
			try {
				if (!future.isCancelled()) {
					WebLink webLink = future.get();
					String webPage = webLink.getHtmlPage();
					if (webPage != null) {
						IOUtil.write(webPage, webLink.getId());
						webLink.setDownloadStatus(WebLink.DownloadStatus.SUCCESS);
						System.out.println("Download Success: " + webLink.getUrl());
					} else {
						System.out.println("donwlaod failed : " + webLink.getUrl());
					}
				} else {
					System.out.println("\n\nTask is cancelled --> " + Thread.currentThread());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}

	private List<Downloader<WebLink>> getTasks(List<WebLink> webLinks) {
		List<Downloader<WebLink>> tasks = new ArrayList<>();
		for (WebLink webLink: webLinks) {
			tasks.add(new Downloader<WebLink>(webLink));
		}
		return tasks;
	}

	private List<WebLink> getWebLinks() {
		// TODO Auto-generated method stub
		List<WebLink> webLinks = null;
		if (downloadAll) {
			webLinks = dao.getAllWebLinks();
			downloadAll = false;
		} else {
			webLinks = dao.getWebLinks(WebLink.DownloadStatus.NOT_ATTEMPTED);
			
		}
		return webLinks;
	}

}
