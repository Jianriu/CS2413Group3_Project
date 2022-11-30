package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class MyController {
    //creates a db connection
    DemoApplication app = new DemoApplication();
    Connection connection = app.initDatabase();
    Hash hash = new Hash();
    @CrossOrigin
    @GetMapping
    public boolean verifyUser(@RequestParam String username, @RequestParam String password) {
        String hashedPass = "";
        try {
            hashedPass = hash.toHexString(hash.getSHAvalue(password));  
        } catch (NoSuchAlgorithmException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        String query = "SELECT * from Users where username = " + "\"" + username + "\"" + "and password = " +  "\"" + hashedPass + "\"";
        System.out.println(query);
        Statement statement;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rs == null){
            return false; 
        }
        else{
            try {
                while(rs.next()){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
        return false;
    }
}
