package com.itda.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
    Users findByUserId(String userId);

    Users findByUserName(String userName);
}
