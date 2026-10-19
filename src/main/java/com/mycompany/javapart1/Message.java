/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javapart1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author ntokozo
 */
public class Message {
    
    // variables are individually public due to an error that occured in MessageText.
    
    public String messageID;
   public int messageNum;
   public String recipient;
   public String messageText;
   public String messageHash;
   
   //This method checks if the message ID is valid
   
   public boolean checkMessageID(){
       if (messageID !=null && messageID.length()<=13){
           return true;
       }else{
           return false;
       }
   }
   
   //This method checks if the cell number has an international code and is <=13 characters.
   
   public String checkRecipientCell(){
       if(recipient.startsWith("+") && recipient.length()<=13){
           return "Cell phone number successfully captured.";
       }else{
           return "cell phone is incorrectly formatted or does not contain an international code.Please correctthe number and try again.";
       }
   }
   
   //This creates the hash
   
   public String createMessageHash(){
       //First lets get the first 2 numbers of the ID.
       String firstTwo=messageID.substring(0, 2);
       
       //this will get the first and last words of the message.
       String[] words=messageText.split(" ");
       String firstWord= words[0];
       String lastWord= words[words.length-1];
       
       //now put all of the conditions together and make them all caps.
       
       String hash=firstTwo+":"+messageNum+":"+firstWord+lastWord;
       return hash.toUpperCase();
   }
   
   //This allows the user to send, disregard or store a message.
   
   public String sentMessage(int choice){
       if(choice==1){
           return "Message successfully sent.";
       }else if (choice==2){
           return "Press 0 to delete the message.";
       }else if (choice==3){
           return "Message successfully stored.";
       }else{
           return "Invalid choice.";
       }
   }
   
   // this method will store the message details to a json file
   
   public void storeMessage(){
       // create a gson object. this makes the JSON file easy to read
      
       Gson gson= new GsonBuilder().setPrettyPrinting().create();
       
       //This will convert the message object into a JSON string format automatically.
       
       
       String jsonString= gson.toJson(this);
       
       //Write the JSON string to a file named message.json
       
       
       try {
          
           // "true" means it will add the new message to the file instead of deletingold ones.
           
           FileWriter writer= new FileWriter("Message.json", true);
           
           // this will write the new line
           writer.write(jsonString+"  ");
           
           writer.close();
       }catch (IOException e){
           System.out.println("An error occurred while saving the message to JSON.");
       }
   }
    
}
