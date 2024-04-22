package com.itda.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();

    }

    public Users findByUserName(String loggedInUserName) {
        return usersRepository.findByUserName(loggedInUserName);
    }

    public Users findByUserId(String userId) {
        return usersRepository.findByUserId(userId);
    }

    @Transactional
    public Users save(Users users){
        return usersRepository.save(users);
    }

}
