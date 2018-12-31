package com.example.service;

import java.util.List;

import com.example.document.User;

public interface UserService {
	public List<User> findAll();
	public User findOneByName(String name);
	public void insert(User user);
	public void update(User user);
	public void remove(String name);
}
