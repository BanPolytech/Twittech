package org.polytech.service;

import org.polytech.business.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
