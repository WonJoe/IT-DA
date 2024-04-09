package com.itda.location;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    
    @CrossOrigin
	@PostMapping("/test")
	public ResponseEntity<?> save(@RequestBody Location location) {
		return new ResponseEntity<>(postService.save(location), HttpStatus.CREATED);
	}

}
