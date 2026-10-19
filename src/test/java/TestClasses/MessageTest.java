/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.javapart1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author ntokozo
 */
public class MessageTest {
    
   @Test
   public void testMessageLengthSuccess(){
       Message msg= new Message();
       msg.messageText="Hi Mike, can you join us for for dinner tonight?";
       assertTrue(msg.messageText.length()<=250);
   }
    
   @Test
   public void testMessageLengthFailure(){
        Message msg= new Message();
        String longText="";
        for (int i=0;i<260; i++){
       longText +="a";
   }
        msg.messageText=longText;
         assertFalse(msg.messageText.length()<=250);
   }
   
   @Test
   public void testRecipientNumCorrect(){
     Message msg= new Message();
     
     msg.recipient= "+27718693002";
     
     msg.recipient= "+2732564";
     String result= msg.checkRecipientCell();
     assertEquals("Cell phone number successfully captured.",result);
   }
   
   @Test
   public void testCreateMessageHash(){
        Message msg= new Message();
        
        msg.messageID ="0012345678";
        msg.messageNum=0;
        msg.messageText= "Hi Mike, can you join us for for dinner tonight?";
        
        String expectedHash= "00:0:HITONIGHT";
        String actualHash= msg.createMessageHash();
        
       assertEquals(expectedHash, actualHash);
   }
   
   @Test
   public void testSentMessageOption(){
        Message msg= new Message();
        
         assertEquals("Message successfully sent.", msg.sentMessage(1));
         assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
         assertEquals("Message successfully stored.", msg.sentMessage(3));
   }
}
