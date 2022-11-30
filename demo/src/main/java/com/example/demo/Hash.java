package com.example.demo;

import java.math.BigInteger ;   
import java.nio.charset.StandardCharsets ;  
import java.security.MessageDigest ;   
import java.security.NoSuchAlgorithmException ; 

public class Hash {
    //Turns the input string into a SHA value in bytes
    public byte[] getSHAvalue( String str ) throws NoSuchAlgorithmException{    
        MessageDigest md = MessageDigest.getInstance("SHA-256");    
        return md.digest(str.getBytes(StandardCharsets.UTF_8 ));   
    }  
    public String toHexString(byte[] hash){  
        // For converting byte array into signum representation   
        BigInteger number = new BigInteger(1, hash);   
        // For converting message digest into hex value   
        StringBuilder hexString = new StringBuilder(number.toString(16));   
    
        // Pad with leading zeros  
        while (hexString.length() < 32)   
        {   
            hexString.insert(0,"0");   
        }   
        return hexString.toString();   
    }  
}
