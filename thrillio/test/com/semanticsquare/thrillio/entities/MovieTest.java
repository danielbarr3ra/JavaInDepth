package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligeble() {
		
		//test 1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFriendly = movie.isKidFriendlyEligeble();
				
		assertFalse(isKidFriendly,"For Horror Genre - isKidFriendlyEligible should return false");
		
		Movie movie2 = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		boolean isKidFriendly2 = movie2.isKidFriendlyEligeble();
				
		assertFalse(isKidFriendly2,"For Horror Genre - isKidFriendlyEligible should return false");
	}

}
