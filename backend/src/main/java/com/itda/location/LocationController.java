package com.itda.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itda.users.Users;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;
    
    @CrossOrigin
	@PostMapping("/test")
	public ResponseEntity<?> save(@RequestBody Location location) {
		Users users = new Users();
		return new ResponseEntity<>(locationService.save(users,location), HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping("/testlist")
	public ResponseEntity<?> findAll() { 
	
		ResponseEntity<?> testentity = new ResponseEntity<>(locationService.findAll(), HttpStatus.OK);

		return testentity;
	}

	@CrossOrigin
	@PostMapping("/testonelist")
	public ResponseEntity<?> matching(@RequestBody Location location) throws Exception {

		// String Strgingid = location.getId();

		// long longValue = location.getId();
		// int id = (int)longValue;
		Long user_no = location.getUserNo();

		ResponseEntity<?> testentity = new ResponseEntity<>(locationService.getMatchingDistance(user_no), HttpStatus.OK);

		return testentity;
	}

	// @CrossOrigin
    // @GetMapping("/testonelist")
    // public ResponseEntity<?> getAllLocations() {
    //     ResponseEntity<?> testentity = new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    //     return testentity;
    // }


}
