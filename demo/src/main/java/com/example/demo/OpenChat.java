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
@RequestMapping("/startChat")
public class OpenChat {
    //creates a db connection
    private static ChatClient chat;

    @CrossOrigin
    @GetMapping
    public boolean ConnectClient(@RequestParam String username, @RequestParam String friendname) {
        try {
            //System.out.println(username + friendname);
            chat = new ChatClient(username, friendname);            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ChatClient getClient(){
        return chat;
    }


}
