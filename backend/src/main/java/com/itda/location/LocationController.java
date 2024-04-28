package com.itda.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itda.dto.ItemDTO;
import com.itda.item.ItemService;
import com.itda.users.Users;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private ItemService itemService;
    
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


	//매칭
	@CrossOrigin
	@PostMapping("/testonelist")
	public ResponseEntity<?> matching(@RequestBody Location location) throws Exception {

		Long userNo = location.getUserNo();

		ItemDTO itemDTO = new ItemDTO();

		itemDTO.setUserNo(userNo);
		//여기서 한번 찾을때마다 쓸 핀 갯수 설정
		int usePinnSearch = 30;
		itemDTO.setPinn(usePinnSearch);
		itemDTO.setDia(0);
		//핀 사용하는 서비스
		itemService.use(itemDTO);

		ResponseEntity<?> testentity = new ResponseEntity<>(locationService.getMatchingDistance(userNo), HttpStatus.OK);

		return testentity;
	}

}
