package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.document.User;
import com.example.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTests {
	
	User user01;
	User user02;
	
	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUp() {
		user01 = new User();
		user01.setName("peter");
		user01.setAge(30);
		userRepository.save(user01);
		
		user02 = new User();
		user02.setName("alie");
		user02.setAge(28);
		userRepository.save(user02);
	}
	
	@Test
	public void findAll() {
		List<User> userList = userRepository.findAll();
		System.out.println(userList);
		assertThat(userList.size()).isEqualTo(2);
	}
	
	@Test
	public void findOneByName() {
		User result = userRepository.findOneByName("peter");
		assertEquals(result.toString(), user01.toString());
	}
	
	@Test
	public void update() {
		user01.setAge(31);
		userRepository.save(user01);
		assertThat(userRepository.findOneByName("peter").getAge()).isEqualTo(31);
	}
	
	@Test
	public void delete() {
		userRepository.delete(user01);
		List<User> userList = userRepository.findAll();
		assertThat(userList.size()).isEqualTo(1);
	}
	
}
