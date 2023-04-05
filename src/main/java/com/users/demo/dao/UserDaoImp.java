
package com.users.demo.dao;

import com.users.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import java.beans.Transient;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;
   @Override

   public void addUser(User user) {
      Long id= user.getId();
      if (id==null) {
         entityManager.persist(user);
      } else {
         edditUser(id,user);
      }
   }
   @Override

   public List<User> getListOfUsers() {
      return entityManager.createQuery("select user from User user", User.class).getResultList();
   }
   @Override

   public void edditUser(Long id, User user){

      User userOld= getUserId(id);
      userOld.setFirstName(user.getFirstName());
      userOld.setLastName(user.getLastName());
      userOld.setMoselMobail(user.getMoselMobail());

   }
   @Override

   public User getUserId(Long id){
      return entityManager.find(User.class, id);
   }

   @Override
   public void deleteUserById(Long id) {
      entityManager.createQuery("delete from User where id='"+id+"'").executeUpdate();
   }
}
