package com.users.demo.service;

import com.users.demo.dao.UserDao;
import com.users.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
   public void edditUser(Long id, User user) {
      userDao.edditUser(id, user);
   }

   @Override
   @Transactional
   public User getUserId(Long id) {
      return userDao.getUserId(id);
   }

   @Override
   public void deleteUserById(Long id) {
      userDao.deleteUserById(id);
   }

   public static void addUS(User user){
      userDao.addUser(user);

   }
}
