package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.UserService;

public class UserController {
	@Autowired
	UserService userService;
}
