
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CaesarCipher {
/*
 *     Write the method encrypt that has two parameters, a String 
 *     named input and an int named key. This method returns a String that 
 *     has been encrypted using the Caesar Cipher algorithm explained in the 
 *     videos. Assume that all the alphabetic characters are uppercase letters. 
 *     For example, the call

        encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)

    should return the string 

        “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
 * 
 */

public String encrypt(String input, int key){
    
    StringBuilder encrypted = new StringBuilder(input);
    
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    String shiftAlpha = alphabet.substring(key) + alphabet.substring(0, key);
    
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        
        char upperCurrChar = Character.toUpperCase(currChar);
        
        int idx = alphabet.indexOf(upperCurrChar);
        
        if(idx != -1){
             char newChar = shiftAlpha.charAt(idx);
             encrypted.setCharAt(i, newChar);
             
        
        }
        else{
        
        encrypted.setCharAt(i, currChar);
        }
        
        
        
    }
    System.out.println(encrypted);
    return encrypted.toString();


}





/*
 * Write the void method testCaesar that has no parameters. This method should read a file 
 * and encrypt the complete file using 
 * the Caesar Cipher algorithm, printing the encrypted message. You may want to include
 * the lines:
 * FileResource fr = new FileResource();
String message = fr.asString();
String encrypted = encrypt(message, key);
System.out.println("key is " + key + "\n" + encrypted);
 */
public void testEncrypt(){
FileResource fr = new FileResource();
String message = fr.asString();
int key = 23;
String encrypted = encrypt(message, key);
System.out.println("key is " + key + "\n" + encrypted);
}


/*
Modify the encrypt method to be able to handle both uppercase and lowercase letters.
 For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and 
 encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”.  Be sure to test 
 the encrypt method.  * 
 * 
 */

/*
 * Write the method encryptTwoKeys that has three parameters, a String named input, 
 * and two integers named key1 and key2. This method returns a String that has been 
 * encrypted using the following algorithm. Parameter key1 is used to encrypt every
 * other character with the Caesar Cipher algorithm, starting with the first character,
 * and key2 is used to encrypt every other character, starting with the second character. 
 * For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”.
 * Note the ‘F’ is encrypted with key 23, the first ‘i’ 
 * with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method. 
 * 
 */

}
