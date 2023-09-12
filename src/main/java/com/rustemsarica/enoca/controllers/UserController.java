package com.rustemsarica.enoca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rustemsarica.enoca.dto.UserDto;
import com.rustemsarica.enoca.models.User;
import com.rustemsarica.enoca.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody UserDto userDto) {
	    User newUser = new User();
	    newUser.setUsername(userDto.getName());
		User saved = userService.save(newUser);
		return ResponseEntity.ok(saved); 
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> delete(@PathVariable Long userId) {
		return userService.delete(userId);
	}
}
