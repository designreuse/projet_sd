package com.nephtysorg.model.pojo;
// Generated 20 avr. 2015 10:17:30 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;

/**
 * Location generated by hbm2java
 */
public class Location  implements java.io.Serializable {


     private Integer id;
     //@Size(min=3, max=20)
     private String label;
     private Set users = new HashSet(0);

    public Location() {
    }

	
    public Location(String label) {
        this.label = label;
    }
    public Location(String label, Set users) {
       this.label = label;
       this.users = users;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }




}


