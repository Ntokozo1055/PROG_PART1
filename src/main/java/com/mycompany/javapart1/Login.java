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
        if(username.contains("_")&& username.length()<=5){
            return true;
        }else{
            return false;
        }
    }
    
    //Check password complexity
    
    boolean checkPasswordComplexity(String password){
        boolean length=false;
        boolean capital=false;
        boolean number=false;
        boolean specialChar=false;
        
        //first check the length
        
        if(password.length()>=8){
            length=true;
        }
        
        //use a while loop to check all the required characters
        
        int i=0;
        while(i<password.length()){
            char character=password.charAt(i);
            
            if(Character.isUpperCase(character)){
                capital=true;
            }else if(Character.isDigit(character)){
                number=true;
            }else if(!Character.isLetterOrDigit(character)){
                specialChar=true;
            }
             i++;       
        }
        
        if(length && number && specialChar){
            return true;
        }else{
            return false;
        }
                
    }
    
    //Check the cell phone number
    
    boolean checkCellPhoneNumber(String cellPhoneNum){
        if(cellPhoneNum.startsWith("+27")&& cellPhoneNum.length()<=10){
            
            int i=1;
            while(i<cellPhoneNum.length()){
                if(!Character.isDigit(cellPhoneNum.charAt(i))){
                    return false;
                }
                i++;
            }
            return true;
        }else{
            return false;
        }
    }
    
    
}
