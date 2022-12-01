package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/chatting")
@RestController
public class ChatController {
    //creates a db connection
    ChatClient c;
    private String response;
    
    @CrossOrigin
    @GetMapping
    public String ConnectClient(@RequestParam String text) {
        try {
            //System.out.println(text);
            //ChatClient chat = new ChatClient(username, friendname);      
            c = OpenChat.getClient(); 
            //this.text = text;   
            c.sendMsg(text);  
            //
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        //System.out.println("controller" + c.getResponse());
        return "true";        
    }

    public void setResponse(String response){
        this.response = response;
    }

    
}
