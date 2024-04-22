package com.itda.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itda.dto.CreateUserRequest;
import com.itda.item.ItemService;
import com.itda.location.Location;
import com.itda.location.LocationService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private HttpSession httpSession;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> users = usersService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/logged-in")
    public ResponseEntity<Users> findLoggedInUser() {
        String loggedInUserId = (String) httpSession.getAttribute("userId");

        Users loggedInUser = usersService.findByUserId(loggedInUserId);

        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Object> craeteUser(@RequestBody CreateUserRequest request) {
        Users users = request.getUsers();
        Location location = request.getLocation();
        
        
        usersService.save(users);
        itemService.save(users);

        return new ResponseEntity<>(locationService.save(users, location), HttpStatus.OK);
    }
}
