package com.itda.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;
    
    @CrossOrigin
	@PostMapping("/test")
	public ResponseEntity<?> save(@RequestBody Location location) {
		return new ResponseEntity<>(locationService.save(location), HttpStatus.CREATED);
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
		long id = location.getId();

		ResponseEntity<?> testentity = new ResponseEntity<>(locationService.getMatchingDistance(id), HttpStatus.OK);

		return testentity;
	}

	// @CrossOrigin
    // @GetMapping("/testonelist")
    // public ResponseEntity<?> getAllLocations() {
    //     ResponseEntity<?> testentity = new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    //     return testentity;
    // }


}
