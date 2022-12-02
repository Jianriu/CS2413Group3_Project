package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
 
public class ChatClient {
 
	Socket cSocket;
	BufferedReader br;
	static PrintWriter out;
	static Scanner scv; 
	private String response = null; 
 
	public ChatClient(String userName, String fName) { 
		System.out.println("Connecting to server");
		try {
			// create thread.
			InetAddress localAddress = InetAddress.getLocalHost();
 
			cSocket = new Socket(localAddress, 9000);
			//System.out.println(cSocket.getLocalPort()); 

			SocketThread st = new SocketThread(); 
			st.start(); 
			
			out = new PrintWriter(cSocket.getOutputStream(), true);
			scv = new Scanner(System.in);

			//System.out.println(userName + " " + fName);
			out.println(userName + " " + fName+"\n");	//send info for connecting
 
			System.out.println(userName + " #conncet to the server");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMsg(String msg){
		//System.out.println("check:"+msg);
		out.println(msg);
	}
 
	class SocketThread extends Thread {

		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(cSocket.getInputStream())); 
				
				
				while ((response = br.readLine()) != null) { 
					// this line should be change
					// when you get response I don't know how to send to svelte!!!
					getResponse();
				}
				//chatController.setMsg(null);
			} catch (Exception e) {
			}
		}

		public String getResponse(){
			System.out.println("response: " + response);
			return response;
		}
	}
	
 

}
