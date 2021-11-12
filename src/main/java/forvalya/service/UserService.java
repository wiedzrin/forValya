package forvalya.service;

import forvalya.entity.User;

public interface UserService {
    User getUserByName(String name);
    void addUser(User user);
    User updateUser(User user);
    void deleteUserByName(String name);
}
