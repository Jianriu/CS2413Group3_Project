package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class ChatServer implements Runnable {
	private static Socket clientSocket; 
	static PrintWriter out = null;
	
    static HashMap<String, Socket> userList = new HashMap<>();  

	public ChatServer(Socket clientSocket) { 
		ChatServer.clientSocket = clientSocket;
	}
	
    
    public static void start(){
        ExecutorService eService = Executors.newFixedThreadPool(10);
		// create limitation thread
 
		System.out.println("#Start the server");
 
		try (ServerSocket sSocket = new ServerSocket(9000)) {
			
			while (true) {
				System.out.println("#connecting ....");
				clientSocket = sSocket.accept();
				ChatServer tes = new ChatServer(clientSocket);
				eService.submit(tes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("#close the server");
		eService.shutdown();
    }
 
	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// OutputStream : send message [server -> client]
			OutputStream out = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
 
			System.out.println("#Client" + "(" + Thread.currentThread() + ")" + " connected!");
 
			String ID = br.readLine(); 
			String inputLine; 

            String UserID = ID.split(" ")[0];
            String FriendID = ID.split(" ")[1];

			writer.println("#[" + UserID + "] Connected, request for connecting with "+FriendID+".");
			userList.put(UserID,clientSocket);

 
			while ((inputLine = br.readLine()) != null) {
				// hashmap friendID:socket
				out = userList.get(FriendID).getOutputStream();
				writer = new PrintWriter(out, true);
				
				writer.println("[" + UserID + "] " + inputLine);			
			}
			out.close();
			System.out.println("#client : " + Thread.currentThread() + " close!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
 
	}

}