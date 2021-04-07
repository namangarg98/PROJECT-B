package com.example.projectdemo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.example.projectdemo.model.User;
import com.example.projectdemo.repository.UserRepository;
import com.example.projectdemo.service.UserService;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
class WebdevprojectApplicationTests {
	@Autowired
	private UserService service;
	@MockBean
	private UserRepository repository;
//	GetALLDetails
	@Test
	public void findAll(){
		repository = mock(UserRepository.class);
		service = new UserService(repository);
	    List<User> studentList = new ArrayList<>();
	    studentList.add(new User(1, "Naman","Garg","Namanng", 22,"12345"));
	    studentList.add(new User(2, "Naman","Garg","Namanng1", 22,"123456"));

	    when(repository.findAll()).thenReturn(studentList);

	    Iterable<User> expectedList = service.showAllUsers();
		int counter = 0;
		for (User i : expectedList) {
		    counter++;
		}
	    assertEquals(2, counter);
	 }
	//Search user
	@Test
	public void getUserById_Test() {
		repository = mock(UserRepository.class);
		service = new UserService(repository);
		User user=new User(1, "Naman","Garg","Namanng", 22,"12345");
		String username = "Namanng";
		when(repository.findByUsername(username)).thenReturn(user);
		assertEquals(user, service.findByUsername(username));
	}
	//Create New User
	@Test
	public void saveUser_Test() {
		repository = mock(UserRepository.class);
		service = new UserService(repository);
		User product = new User(1, "Naman","Garg","Namanng", 22,"12345");
		when(repository.save(product)).thenReturn(product);
		assertEquals(product, service.saveMyUser(product));
	}
	//Delete User
	@Test
	public void deleteUser_Test() {
		repository = mock(UserRepository.class);
		service = new UserService(repository);
		service.deleteUserByUsername("Namanng");
		verify(repository,times(1)).deleteByUsername("Namanng");
	}
}