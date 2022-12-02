package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/startChat")
public class OpenChat {
    //creates a db connection
    private ChatClient chat;

    @CrossOrigin
    @GetMapping
    public boolean ConnectClient( @RequestParam String username, @RequestParam String fname) {
        try {
            //System.out.println(username + friendname);
            //chat = new ChatClient(username, fname);            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
