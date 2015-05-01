package com.nephtysorg.model.pojo;
// Generated 20 avr. 2015 10:17:30 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer id;
     private Location location;
     @Size(min = 5, max = 20)
     private String login;
     @Size(min = 5, max = 20)
     private String password;
     

     private Set groups = new HashSet(0);
     private Set userGroups = new HashSet(0);

    public User() {
    }

	
    public User(Location location, String login, String password) {
        this.location = location;
        this.login = login;
        this.password = password;
    }
    public User(Location location, String login, String password, Set groups, Set userGroups) {
       this.location = location;
       this.login = login;
       this.password = password;
       this.groups = groups;
       this.userGroups = userGroups;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }
    public Set getUserGroups() {
        return this.userGroups;
    }
    
    public void setUserGroups(Set userGroups) {
        this.userGroups = userGroups;
    }




}


