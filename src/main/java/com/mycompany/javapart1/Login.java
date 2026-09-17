/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javapart1;

/**
 *
 * @author ntokozo
 */
public class Login {
    //Declarations
    String registeredUsername;
    String registeredPassword;
    String registeredCellNum;
    String firstName;
    String lastName;
    
    //Check username
    
    boolean checkUsername(String username){
        return username.contains("_")&& username.length()<=5;
    }
}
