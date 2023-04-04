package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private static UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   @Transactional
   public List<User> getListOfUsers() {
      return userDao.getListOfUsers();
   }

   @Override
   @Transactional
   public void removeUser(long id, User user) {
      userDao.removeUser(id, user);
   }

   @Override
   @Transactional
   public User getUserId(long id) {
      return userDao.getUserId(id);
   }

   @Override
   public void deleteUserById(long id) {
      userDao.deleteUserById(id);
   }

   public static void addUS(User user){
      userDao.addUser(user);

   }
}
