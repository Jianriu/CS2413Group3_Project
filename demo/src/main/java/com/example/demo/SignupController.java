package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
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
    Hash hash = new Hash();
    @CrossOrigin
    @PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean signUp(@RequestBody User user){
        String hashedPass = "";
        try {
            hashedPass = hash.toHexString(hash.getSHAvalue(user.getPassword()));  
        } catch (NoSuchAlgorithmException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       
        String query = "INSERT INTO Users (fullname,username,password,email) VALUES ("
         + "\"" + user.getFullname() + "\"," 
         + "\"" + user.getFullname() + "\"," 
         + "\"" + hashedPass + "\"," 
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
