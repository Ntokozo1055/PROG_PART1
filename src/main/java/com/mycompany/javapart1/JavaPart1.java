/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javapart1;
import java.util.Scanner;
/**
 *
 * @author ntokozo
 */
public class JavaPart1 {

    public static void main(String[] args) {
        //declaration
        String username;
        String name;
        String surname;
        String password;
        String cellPhoneNum;
        
        Scanner myInput=new Scanner(System.in);
        Login loginSystem=new Login();
        
        System.out.println("=====REGISTERATION=====");
        boolean isRegistered=false;
        
        //while loop so that the code can rerun after a mistake
        
        while(isRegistered==false){
            System.out.print("Enter your first name: ");
            name=myInput.nextLine();
            
            System.out.print("Enter your last name: ");
            surname=myInput.nextLine();
            
            System.out.println("The username must contain an underscore '_' and should be maximum 5 characters.");
            System.out.print("Enter your username name: ");
            username=myInput.nextLine();
            
            System.out.println("the password must contain a minimum of 8 characters, 1 capital letter, 1 number and 1 special character.");
            System.out.print("Enter your password: ");
            password=myInput.nextLine();
            
            System.out.print("Enter your south african cell phone number (e.g. +27603425132): ");
            cellPhoneNum=myInput.nextLine();
            
            //call the register method from the login class and display a message
            String registerMessage=loginSystem.registerUser(username, password, cellPhoneNum, name, surname);
            System.out.println(registerMessage);
            
            if(registerMessage.equals("User registered successfully.")){
                isRegistered=true;
            }else{
                System.out.println("Please try registering again");
            }
        }
        
        //login section
        
        System.out.println("=====LOGIN=====");
        boolean isLoggedIn=false;
        
        while(isLoggedIn=false){
            System.out.print("Enter username: ");
            String loginUsername=myInput.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword=myInput.nextLine();
            
            //call the login method
            isLoggedIn=loginSystem.loginUser(loginUsername, loginPassword);
            
            //display the status method
            System.out.println(loginSystem.returnLoginStatus(isLoggedIn));
            
            if(isLoggedIn==false){
                System.out.println("Please try logging in again.");
            }
        }
        
        System.out.println("Have a great day!");
        myInput.close();
    }
}
