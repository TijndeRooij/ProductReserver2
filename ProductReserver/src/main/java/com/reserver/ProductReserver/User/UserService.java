package com.reserver.ProductReserver.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public void createUser(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        newUser.setBirthday(user.getBirthday());
        System.out.println(newUser.getPassword());
        userRepo.save(newUser);
    }
}
