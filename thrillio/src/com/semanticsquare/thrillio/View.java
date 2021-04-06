package com.semanticsquare.thrillio;

import java.util.List;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;

public class View {

	public static void browse(User user,List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items ...");
		//int bookmarkCount = 0;

		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				//if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
				
				//
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						//bookmarkCount++;
						// controller
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New item is bookmarked ----" + bookmark);
					}
				//}
				// Mark as Kid- Friendly
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligeble()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						KidFriendlyStatus kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
						}
					}
					//Sharing!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && (bookmark instanceof Shareable)) {
						boolean isShared = getShareDecision();
						if (isShared) {
							BookmarkController.getInstance().share(user,bookmark);
						}
					}
				}
			}
		}
	}
	//TODO: below methods siumlate user input. after IO, we take input via console.
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
		
	}

	private static KidFriendlyStatus getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}
}
