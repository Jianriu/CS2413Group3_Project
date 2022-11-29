package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SignupController {
    DemoApplication app = new DemoApplication();
    Connection connection = app.initDatabase();
    @CrossOrigin
    @PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean signUp(@RequestBody User user){
        String query = "INSERT INTO Users (fullname,username,password,email) VALUES ("
         + "\"" + user.getFullname() + "\"," 
         + "\"" + user.getUsername() + "\"," 
         + "\"" + user.getPassword() + "\"," 
         + "\"" + user.getEmail() + "\"" + ")";
         System.out.println(query);
         Statement statement;
         try {
             statement = connection.createStatement();
             statement.executeUpdate(query);
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
}
