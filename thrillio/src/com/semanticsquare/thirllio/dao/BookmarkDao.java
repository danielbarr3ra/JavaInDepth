package com.semanticsquare.thirllio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;

public class BookmarkDao {
	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();

	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		// TODO Auto-generated method stub
		// DataStore.add(userBookmark);
		// matin 3 tables in database to capture the user bookmark action we gotta
		// create those tables; in mysql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false",
				"root", "*******"); Statement stmt = conn.createStatement();) {
			System.out.println("hello");
			if (userBookmark.getBookmark() instanceof Book) {
				saveUserBook(userBookmark, stmt);
			} else if (userBookmark.getBookmark() instanceof Movie) {
				saveUserMovie(userBookmark, stmt);
			} else {
				saveUserWebLink(userBookmark, stmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void saveUserWebLink(UserBookmark userBookmark, Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into User_Book (user_id, book_id) values (" + userBookmark.getUser().getId() + ", "
				+ userBookmark.getBookmark().getId() + ")";
		stmt.executeUpdate(query);
	}

	private void saveUserMovie(UserBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert into User_Movie (user_id, movie_id) values (" + userBookmark.getUser().getId() + ", "
				+ userBookmark.getBookmark().getId() + ")";
		stmt.executeUpdate(query);
		// TODO Auto-generated method stub

	}

	private void saveUserBook(UserBookmark userBookmark, Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into User_WebLink (user_id, weblink_id) values (" + userBookmark.getUser().getId() + ", "
				+ userBookmark.getBookmark().getId() + ")";
		stmt.executeUpdate(query);

	}

	public List<WebLink> getAllWebLinks() {
		List<WebLink> result = new ArrayList<>();
		List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
		List<Bookmark> allWebLinks = bookmarks.get(0);

		for (Bookmark bookmark : allWebLinks) {
			result.add((WebLink) bookmark);
		}

		return result;
	}

	public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus) {
		List<WebLink> result = new ArrayList<>();

		List<WebLink> allWebLinks = getAllWebLinks();
		for (WebLink webLink : allWebLinks) {
			if (webLink.getDownloadStatus().equals(downloadStatus))
				;
			{
				result.add(webLink);
			}
		}

		return result;
	}

	public void updateKidFriendlyStatus(Bookmark bookmark) {
		int kidFriendlyStatus = bookmark.getKidFriendlyStatus().ordinal();
		long userId = bookmark.getKidFriendlyMarkedBy().getId();

		String tableToUpdate = "Book";
		if (bookmark instanceof Movie) {
			tableToUpdate = "Movie";
		} else if (bookmark instanceof WebLink) {
			tableToUpdate = "WebLink";
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false",
				"root", "*******"); Statement stmt = conn.createStatement()) {
			// System.out.println("hello");
			String query = "update " + tableToUpdate + " set kid_friendly_status = " + kidFriendlyStatus
					+ ", kid_friendly_marked_by = " + userId + " where id = " + bookmark.getId();
			System.out.println("query updatekidfreindlstyats: " + query);
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handlee exception

		}

	}

	public void sharedByInfo(Bookmark bookmark) {
		// TODO Auto-generated method stub
		long userId = bookmark.getSharedBy().getId();

		String tableToUpdate = "Book";
		if (bookmark instanceof WebLink) {
			tableToUpdate = "WebLink";
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false",
				"root", "*******"); Statement stmt = conn.createStatement()) {
			// System.out.println("hello");
			String query = "update " + tableToUpdate + " set shared_by = " + userId
					+ " where id = " + bookmark.getId();
			System.out.println("query updatekidfreindlstyats: " + query);
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handlee exception

		}
	}
}
