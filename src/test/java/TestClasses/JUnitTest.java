/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.javapart1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author ntokozo
 */
public class JUnitTest {
    
    Login login=new Login();
    
    //test 1: Username
    
    @Test
    public void testUsernameCorrectlyFormatted(){
        assertTrue(login.checkUsername("kyl_1"));
        
    }
    
    @Test
    public void testUsernameIncorrectlyFormatted(){
        assertFalse(login.checkUsername ("kyle!!!!!!!"));
    }
    
    //test 2: Password
    
    @Test
    public void testPasswordMeetsComplexity(){
        assertTrue(login.checkPasswordComplexity("Ch&&se@ke99!"));
    }
    
    @Test
    public void testPasswordDoesntMeetComplexity(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    //test 3: cell phone number
    
    @Test
    public void testCellPhoneCorrectlyFormatted(){
        assertTrue(login.checkCellPhoneNumber("+278389689"));
    }
    
    @Test 
    public void testCellPhoneIncorrectlyFormatted(){
        assertFalse(login.checkCellPhoneNumber("0838962525"));
    }
    
    //test 4: Registeration messages
    
    @Test
    public void testRegisterationSuccess(){
        String expectedMessage="User registered successfully.";
        String actualMessage=login.registerUser("kyl_1", "Ch&&sec@ke99!","+278389689","Kyle","Smith");
        assertEquals(expectedMessage,  actualMessage);
    }
    
    @Test
    public void testRegisterationFailsUsername(){
        String expectedMessage="Username is not correctly formatted; Please ensure that your username has an underscore and is maximum 5 characters.";
        String actualMessage=login.registerUser("kyle!!!!!!!","Ch&&sec@ke99!","+278389689","Kyle","Smith");
        assertEquals(expectedMessage,  actualMessage);
    }
    
    @Test
    public void testRegisterationFailsPassword(){
        String expectedMessage="Password is not correctly formatted; please ensure that the password containsat least 8 characters, a capital letter, a number and a special character.";
        String actualMessage=login.registerUser("kyl_1", "password","+278389689","Kyle","Smith");
         assertEquals(expectedMessage,  actualMessage);
    }
    
    @Test
    public void testRegisterationFailsCellNumber(){
        String expectedMessage="Cell Phone number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        String actualMessage=login.registerUser("kyl_1", "Ch&&sec@ke99!","08389689","Kyle","Smith");
        assertEquals(expectedMessage,  actualMessage);
    }
    
    //test 5: Login successful or failure
    
    @Test
    public void testLoginSuccess(){
        login.registerUser("kyl_1", "Ch&&sec@ke99!","+278389689","Kyle","Smith");
        boolean isLoggedIn=login.loginUser("kyl_1","Ch&&sec@ke99!");
        String  expectedMessage="Welcome kyle, smith it is great to see you.";
        String actualMessage=login.returnLoginStatus(isLoggedIn);
        assertEquals(expectedMessage,  actualMessage);
    }
    
    @Test
    public void testLoginFailed(){
        login.registerUser("kyl_1", "Ch&&sec@ke99!","+278389689","Kyle","Smith");
         boolean isLoggedIn=login.loginUser("kyl_1","wrongpassword123");
         String expectedMessage="Username or password incorrect, please try again.";
         String actualMessage=login.returnLoginStatus(isLoggedIn);
         assertEquals(expectedMessage,  actualMessage);
    }
            
}
