
package com.users.demo.dao;

import com.users.demo.model.User;
import org.springframework.transaction.annotation.Transactional;


import java.beans.Transient;
import java.util.List;

public interface UserDao {
   @Transient
   void addUser(User user);
   List<User> getListOfUsers();



    void edditUser(Long id, User user);



    User getUserId(Long id);

    void deleteUserById(Long id);

}