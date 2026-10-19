/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javapart1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author ntokozo
 */
public class JavaPart2 {
    
    public static void main(String[]args){
        Scanner Myinput=new Scanner(System.in);
        
        //Lets assume that the user logged in with no problems
        
        System.out.println("Welcome to QuickChat.");
        
        //Ask the user how many messages they want to send
        
        System.out.print("How many messages do you want to send.");
        int numMessage=Myinput.nextInt();
        Myinput.nextLine();
        
        //Now we create ab arraylist to store the messages.
        
        ArrayList<Message> allMessage= new ArrayList<>();
        boolean running=true;
        int messageSentCount=0;
        
        //This loop with keep the app running until the user chooses quit.
        
        while(running){
            System.out.println("====MENU====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages.");
            System.out.println("3. Quit.");
            System.out.println("Choose an option: ");
            
            int menuChoice= Myinput.nextInt();
            Myinput.nextLine();
            
            if(menuChoice == 1){
                
                //check if they have passed their limit
                
                if(messageSentCount>= numMessage){
                    System.out.println("You have reached your message limit.");
                    continue; 
                }
                
                System.out.println("=====New Message=====");
                Message myMessage= new Message();
                
                //generate random 10 digit ID
                
                Random rand= new Random();
                long randomNum=(long)(rand.nextDouble()* 10000000000L);
                myMessage.messageID= String.format("%010d", randomNum);
                
                //Set the message number
                
                myMessage.messageNum= messageSentCount + 1;
                
                //Ask for recipient
                System.out.print("Enter reicipient cell number (+27): ");
                myMessage.recipient= Myinput.nextLine();
                
                //ask for message text max 250 characters
                
                 System.out.println("Enter message.");
                 myMessage.messageText= Myinput.nextLine();
                 
                 // check the length of the message.
                 if(myMessage.messageText.length()>250){
                      System.out.println("Message exceeds 250 characters by"+ (myMessage.messageText.length()>250)+"; please reduce the size ." );
                      
                 }else{
                     // create the hash
                     
                     myMessage.messageHash= myMessage.createMessageHash();
                     
                     //Ask what to do with the message
                     
                     System.out.println("What do you want to do?");
                     System.out.println("1. Send.");
                     System.out.println("2. Disregard.");
                     System.out.println("3. Store Message.");
                     
                     int sendChoice= Myinput.nextInt();
                     Myinput.nextLine();
                     
                     String status= myMessage.sentMessage(sendChoice);
                     System.out.println(status);
                     
                     //if they send the message send, save and count it.
                     
                     if(sendChoice == 1){
                         allMessage.add(myMessage);
                         messageSentCount++;
                         
                         // print all the details
                         System.out.println("Message Detail: ");
                         System.out.println("Message ID: "+ myMessage.messageID);
                         System.out.println("Message Hash: "+ myMessage.messageHash);
                         System.out.println("Recipient: "+ myMessage.recipient);
                         System.out.println("Message: "+ myMessage.messageText);
                         
                     }else if(sendChoice ==2){
                         
                     }else if(sendChoice == 3){
                         
                         myMessage.storeMessage();
                     }else{
                         System.out.println("Invalid choice.Message discarded.");
                     }
                 }
            }else if(menuChoice ==2){
                System.out.println("Coming Soon");
            }else if(menuChoice == 3){
                running=false;
                System.out.println("Total message successfully sent: "+ messageSentCount);
                System.out.println("Goodbye!");
            }else{
                System.out.println("Invalid option.Try again.");
            }
        }
        Myinput.close();
    }
    
}
