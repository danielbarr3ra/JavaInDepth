package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligeble() {
		//test1 porn in url -- false
		WebLink webLink = BookmarkManager.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-porn-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		boolean isKidFriendlyEligeble = webLink.isKidFriendlyEligeble();
		
		assertFalse(isKidFriendlyEligeble,"for porn in URL method must return false");
		//test2 porn in title -- false
		WebLink webLink2 = BookmarkManager.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java porn into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		boolean isKidFriendlyEligeble2 = webLink2.isKidFriendlyEligeble();
		
		assertFalse(isKidFriendlyEligeble2,"for porn in title method must return false");
		
		//test3 adult in host --false
		WebLink webLink3 = BookmarkManager.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java  into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.adult.com");
		boolean isKidFriendlyEligeble3 = webLink3.isKidFriendlyEligeble();
		
		assertFalse(isKidFriendlyEligeble3,"for adult in host method must return false");
		
		//test4 adult in url, but not in host part --true
		WebLink webLink4 = BookmarkManager.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java  into Eclipse and get up and running?",
				"http://adult.com/questions/142863/how-do-i-import-a-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.hello.com");
		boolean isKidFriendlyEligeble4 = webLink4.isKidFriendlyEligeble();
		
		assertTrue(isKidFriendlyEligeble4,"for adult in URL but not in host method must return true");
		
		//test5 adult in title --true
		WebLink webLink5 = BookmarkManager.getInstance().createWebLink(2001,
				"How do I import a pre-existing Java adult  into Eclipse and get up and running?",
				"http://.com/questions/142863/how-do-i-import-a-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.hello.com");
		boolean isKidFriendlyEligeble5 = webLink5.isKidFriendlyEligeble();
		
		assertTrue(isKidFriendlyEligeble5,"for adult in title method must return true");
		
	}

}
