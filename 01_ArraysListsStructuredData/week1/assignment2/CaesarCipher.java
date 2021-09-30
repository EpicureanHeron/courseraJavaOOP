
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
    
    String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    String shiftAlphaUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);
    
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        
        char upperCurrChar = Character.toUpperCase(currChar);
        
        int idx = alphabetUpper.indexOf(upperCurrChar);
        //checks to see if value is in the alphabet string
        if(idx != -1){
            //then go ahead and select the shifted alphabet character
             char newChar = shiftAlphaUpper.charAt(idx);
             //if the original value is upper case
             if(Character.isUpperCase(currChar)){
             
             //and add it to the encrypted message
             encrypted.setCharAt(i, newChar);
                }
                //if not upper case (therefore lower case)
             else{
                 
             //transform the character selected lowercase
             char lowerNewChar = Character.toLowerCase(newChar);
             //add the lower case to the encrypted message
             encrypted.setCharAt(i, lowerNewChar);
                }

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
//FileResource fr = new FileResource();
//String message = fr.asString();
String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
int key = 15;
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


public void testModifiedEncrypt(){

int key = 23;
String encrypted = encrypt("First Legion", key);
System.out.println("key is " + key + "\n" + encrypted);


int key2 = 17;
String encrypted2 = encrypt("First Legion", key2);
System.out.println("key is " + key2 + "\n" + encrypted2);
}

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

public String encryptTwoKeys(String input, int key1, int key2){

StringBuilder encrypted = new StringBuilder(input);
    
    String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    String shiftAlpha1 = alphabetUpper.substring(key1) + alphabetUpper.substring(0, key1);
    String shiftAlpha2 = alphabetUpper.substring(key2) + alphabetUpper.substring(0, key2);
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        
        char upperCurrChar = Character.toUpperCase(currChar);
        
        int idx = alphabetUpper.indexOf(upperCurrChar);
        //checks to see if value is in the alphabet string
        if(idx != -1 && i%2 == 0){
            //then go ahead and select the shifted alphabet character
             char newChar = shiftAlpha1.charAt(idx);
             //if the original value is upper case
             if(Character.isUpperCase(currChar)){
             
             //and add it to the encrypted message
             encrypted.setCharAt(i, newChar);
                }
                //if not upper case (therefore lower case)
             else{
                 
             //transform the character selected lowercase
             char lowerNewChar = Character.toLowerCase(newChar);
             //add the lower case to the encrypted message
             encrypted.setCharAt(i, lowerNewChar);
                }
            }
        else if(idx != -1 && i%2 != 0){
        
                     char newChar = shiftAlpha2.charAt(idx);
             //if the original value is upper case
             if(Character.isUpperCase(currChar)){
             
             //and add it to the encrypted message
             encrypted.setCharAt(i, newChar);
                }
                //if not upper case (therefore lower case)
             else{
                 
             //transform the character selected lowercase
             char lowerNewChar = Character.toLowerCase(newChar);
             //add the lower case to the encrypted message
             encrypted.setCharAt(i, lowerNewChar);
        
        }
        }
        else{
        
        encrypted.setCharAt(i, currChar);
        }
        
        
        
    }
    System.out.println(encrypted);
    return encrypted.toString();


}
 public void testEncryptTwoKeys(){
    int key1 = 12;
    int key2 = 2;
String encrypted = encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy", key1, key2);
System.out.println("key1 is " + key1 + "\n Key2 is"+ key2 +"\n" + encrypted);
    
    
    }

}
