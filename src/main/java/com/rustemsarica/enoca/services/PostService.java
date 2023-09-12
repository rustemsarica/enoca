package com.rustemsarica.enoca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rustemsarica.enoca.models.Post;
import com.rustemsarica.enoca.models.User;
import com.rustemsarica.enoca.repositories.PostRepository;

@Service
public class PostService {
    @Autowired
	PostRepository pRepository;

    public Optional<Post> getPost(Long id){
        return pRepository.findById(id);
    }

	public ResponseEntity<?> getAllPosts() {
		List<Post> posts = pRepository.findAll();
		return ResponseEntity.ok(posts);
	}
	
	public ResponseEntity<?> save(String text, User user) {
	    Post post = new Post();
	    post.setText(text);
		post.setUser(user);
		pRepository.save(post);
		return ResponseEntity.ok("Post saved.");  
	}

	public ResponseEntity<?> update(Long postId, String text) {
		Post post = getPost(postId).get();
        post.setText(text);
        pRepository.save(post);
		return ResponseEntity.ok("Post updated."); 
	}
	
	public ResponseEntity<?> delete(Long postId) {
		pRepository.deleteById(postId);
		return ResponseEntity.ok("Post deleted."); 
	}
}
