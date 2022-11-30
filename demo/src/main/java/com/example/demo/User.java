package com.example.demo;
//User object used to accept request body for users
public class User {
    private String username;
    private String fullname; 
    private String password;
    private String email;
    public User(){}
    public User (String u, String f, String p,String e){
        username = u;
        fullname = f;
        password = p;
        email = e;
    }

    public String getUsername(){
        return this.username;
    }
    public String getFullname(){
        return this.fullname;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
}
