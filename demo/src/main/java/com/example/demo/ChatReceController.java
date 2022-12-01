package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import org.apache.catalina.connector.Response;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Rsocket;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/chatRece")
public class ChatReceController {
    //creates a db connection
    ChatClient c;
    private String response;
    /*private String response = null;
    public void setResponse(String r){
        this.response = r;
    } */

    public void setResponse(String response){
		//System.out.println("response: " + response);
		//return response;
        this.response = response;
	}
    

    @CrossOrigin
    @GetMapping
    public String sendClient() {
        try {
            System.out.println("controller response" + response);
             
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response;
        //System.out.println("controller" + c.getResponse());
               
    }    
}
