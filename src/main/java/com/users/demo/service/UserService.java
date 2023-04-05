
package com.users.demo.service;

import com.users.demo.model.User;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface UserService {
    @Transactional
    void addUser(User user);
    @Transactional(readOnly=true)

    List<User> getListOfUsers();

    @Transactional
    void edditUser(Long id, User user);


    @Transactional(readOnly=true)
    User getUserId(Long id);

    @Transactional
    void deleteUserById(Long id);
}
