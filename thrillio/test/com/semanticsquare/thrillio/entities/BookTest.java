package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	public void testIsKidFriendlyEligeble() {
	Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
			new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
	boolean isKidFriendly = book.isKidFriendlyEligeble();
	assertFalse(isKidFriendly,"for philosophy it should return false");

	Book book2 = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
			new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
	boolean isKidFriendly2 = book2.isKidFriendlyEligeble();
	assertFalse(isKidFriendly2,"for self help it should return false");
}
}