package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//Connects to the database
		String url = "jdbc:mysql://localhost:3306/CS2413";
		String user = "root";
		String password = "GRMT#1092";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Connect success");
		SpringApplication.run(DemoApplication.class, args);
	}

}
