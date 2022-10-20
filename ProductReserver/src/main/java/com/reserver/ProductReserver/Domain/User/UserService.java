package com.reserver.ProductReserver.Domain.User;

import com.reserver.ProductReserver.Domain.Role.Role;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
