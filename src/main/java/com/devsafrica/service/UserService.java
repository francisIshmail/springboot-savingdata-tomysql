package com.devsafrica.service;


import com.devsafrica.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
