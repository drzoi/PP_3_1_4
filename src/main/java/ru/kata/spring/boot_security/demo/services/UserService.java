package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> getAllUsers();

    boolean addUser(User user);

    User findByEmail(String email);

    User findByFirstname(String firstname);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);

    void setUserRoles(User user, Set<Long> roleIds);
}
