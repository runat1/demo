
package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.beans.Transient;
import java.util.List;

public interface UserDao {
   @Transient
   void addUser(User user);
   List<User> getListOfUsers();


    @Transactional
    void removeUser(Long id, User user);


    @Transactional
    User getUserId(long id);

    void deleteUserById(long id);

}