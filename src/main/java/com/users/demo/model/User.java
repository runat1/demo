package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;
   @Column(name = "moselMobail")
   private String moselMobail;



   public User() {}

   public User(String firstName, String lastName, String moselMobail) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.moselMobail=moselMobail;

   }

   public String getMoselMobail() {
      return moselMobail;
   }

   public void setMoselMobail(String moselMobail) {
      this.moselMobail = moselMobail;
   }


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }



}
