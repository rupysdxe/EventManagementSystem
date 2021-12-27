package com.example.eventmanagementsystem.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;

@Getter
@Setter
@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String position;

  public Admin(){

  }
    public Admin(String firstName, String lastName, String username, String password, String position) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.position = position;
    }
}
