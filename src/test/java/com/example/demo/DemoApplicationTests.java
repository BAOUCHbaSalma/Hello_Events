package com.example.demo;

import com.example.demo.model.Erole;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DemoApplicationTests {

//	@Autowired
//	private UserService userService;
//
//	@Test
//	public void AddUserTest() {
//
//		User user = new User("Wissal", "wissal@gmail.com", "123", 24);
//
//		userService.signUp(user);
//
//		assertNotNull(user.getUserId());
//		assertEquals("Wissal", user.getUsername());
//		assertEquals("wissal@gmail.com", user.getEmail());
//		assertEquals(Erole.USER, user.getRole());
//		assertEquals(24, user.getAge());
//	}
//	@Test
//	public void ShowUserTest() {
//
//
//		List<User> users=userService.findAllRegistre();
//
//
//		assertEquals(1, users.get(0).getUserId());
//		assertEquals(2, users.get(1).getUserId());
//
//	}
}