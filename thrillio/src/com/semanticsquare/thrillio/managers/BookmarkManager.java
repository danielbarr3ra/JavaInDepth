package com.semanticsquare.thrillio.managers;
import java.util.List;

import com.semanticsquare.thirllio.dao.BookmarkDao;
import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, MovieGenre genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);
		return movie;
	}

	public Book createBook(long Id, String title, int publicationYear, String publisher, String[] authors, BookGenre genre,
			double amazaonRating) {
		Book book = new Book();
		book.setId(Id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazaonRating(amazaonRating);
		return book;
	}

	public WebLink createWebLink(long Id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(Id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);
		return weblink;
	}

	public List<List<Bookmark>> getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		

		dao.saveUserBookmark(userBookmark);

	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		dao.updateKidFriendlyStatus(bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: ");
		if (bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		} else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());
		}
		
		dao.sharedByInfo(bookmark);
	}
}
