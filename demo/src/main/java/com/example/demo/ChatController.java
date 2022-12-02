package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/chatting")
@RestController
public class ChatController {
    //creates a db connection
    ChatClient chat = null;
    
    @CrossOrigin
    @GetMapping
    public String ConnectClient( @RequestParam String username, @RequestParam String fname, @RequestParam String text) {
        try {
            //System.out.println(username + friendname);
            chat = new ChatClient(username, fname); 
            chat.sendMsg(text);           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "false";
        }
        return "true";      
    }
    
    
}
