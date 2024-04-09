package com.itda.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PostController { 
 
	@Autowired 
	private PostService postService; 
	 
	@CrossOrigin
	@PostMapping("/post")
	public ResponseEntity<?> save(@RequestBody Post post) {
		return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/post")
	public ResponseEntity<?> findAll() { 
	
		ResponseEntity<?> testentity = new ResponseEntity<>(postService.findAll(), HttpStatus.OK);

		return testentity;
	}

	@CrossOrigin
	@GetMapping("/test")
	public ResponseEntity<?> test() { 
	
		ResponseEntity<?> testentity = new ResponseEntity<>(postService.findAll(), HttpStatus.OK);

		return testentity;
	}


}