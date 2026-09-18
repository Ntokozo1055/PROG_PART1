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
    
    public boolean checkUsername(String username){
        if(username.contains("_")&& username.length()<=5){
            return true;
        }else{
            return false;
        }
    }
    
    //Check password complexity
    
    public boolean checkPasswordComplexity(String password){
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
        
        if(length && capital  &&  number && specialChar){
            return true;
        }else{
            return false;
        }
                
    }
    
    //Check the cell phone number
    
    public boolean checkCellPhoneNumber(String cellPhoneNum){
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
    
    // now this will register the user
    
   public String registerUser(String username, String password, String cellPhoneNum, String name, String surname){
        this.firstName=name;
        this.lastName=surname;
        
        if(!checkUsername(username)){
            return "Username is not correctly formatted; Please ensure that your username has an underscore and is maximum 5 characters.";
            
        }
        if(!checkPasswordComplexity(password)){
            return "Password is not correctly formatted; please ensure that the password containsat least 8 characters, a capital letter, a number and a special character.";
            
        }
        if(!checkCellPhoneNumber(cellPhoneNum)){
            return "Cell Phone number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        this.registeredUsername=username;
        this.registeredPassword=password;
        this.registeredCellNum=cellPhoneNum;
        
        return "User registered successfully.";
    }
    
    //now this will log the user into the "account"
    
    public boolean loginUser(String enteredUsername, String enteredPassword){
        if(enteredUsername.equals(registeredUsername)&& enteredPassword.equals(registeredPassword)){
            return true;
        }else{
            return false;
        }
    }
    
    //return login status
    
     public String returnLoginStatus(boolean isLoggedIn){
        if(isLoggedIn){
            return"Welcome "+ firstName+","+lastName+" it is great to see you.";
        }else{
            return "Username or Password is incorrect, please try again.";
        }
    }
}
