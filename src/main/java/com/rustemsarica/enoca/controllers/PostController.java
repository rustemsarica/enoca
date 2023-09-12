package com.rustemsarica.enoca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rustemsarica.enoca.dto.PostDto;
import com.rustemsarica.enoca.services.PostService;
import com.rustemsarica.enoca.services.UserService;


@RestController
@RequestMapping("/posts")
public class PostController {


	@Autowired
	PostService postService;

	@Autowired
	UserService userService;

	
	@GetMapping
	public ResponseEntity<?> index() {
		return postService.getAllPosts();
	}

	@GetMapping("/{postId}")
	public ResponseEntity<?> getPost(@PathVariable Long postId) {
		return ResponseEntity.ok(postService.getPost(postId));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PostDto postDto) {
	    return postService.save(postDto.getText(), userService.getUser(postDto.getUserId())); 
	}

	@PutMapping("/{postId}")
	public ResponseEntity<?> update(@PathVariable Long postId, @RequestBody PostDto postDto) {
		return postService.update(postId, postDto.getText());
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> delete(@PathVariable Long postId) {
		return postService.delete(postId);
	}
}
