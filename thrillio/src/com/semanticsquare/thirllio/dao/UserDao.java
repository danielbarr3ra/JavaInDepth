package com.semanticsquare.thirllio.dao;

import java.util.List;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.User;

public class UserDao {
	public List<User> getUsers() {
		return DataStore.getUsers();
	}
}
