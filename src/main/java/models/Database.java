/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import  java.sql.*;
/**
 *
 * @author itxas
 */
public class Database {
    private String username ="root";
    private String pass ="";
    private String url ="jdbc:mysql://localhost:3306/Socialmedia";
    private Statement statement;
public Database(){
    try {
        Connection connection =  DriverManager.getConnection(url,username,pass);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
 
}    
public Statement GetStatement(){
    return statement;
}
}
