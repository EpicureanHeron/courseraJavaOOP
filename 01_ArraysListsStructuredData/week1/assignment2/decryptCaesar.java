
/**
 * Write a description of decryptCaesar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class decryptCaesar {
/*
 Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods countLetters, maxIndex, and decrypt. 
 Recall that the decrypt method creates a CaesarCipher object in order to use the 
 encrypt method you wrote for the last lesson. Make sure that your CaesarCipher class is in the same folder as CaesarBreaker! 
 You may want to use the following code as part of your decrypt method.
 */

   public String decrypt(String encrypted){
       int[] freqs = countLetters(encrypted);
       int maxIndex = maxIndex(freqs);
       
       
        int dkey;
       
        dkey = maxIndex - 4;
        
        if (maxIndex < 4) {
            dkey = 26 - (4-maxIndex);
        
        }
        CaesarCipher cc = new CaesarCipher();
       String message = cc.encrypt(encrypted, 26-dkey);
    
    return message;
}

 public int maxIndex(int[] counts){
    int maxValue = 0;
    int maxIndex = 0;
    
    for(int i=0; i < counts.length; i++){
        if(counts[i] > maxValue){
            maxValue = counts[i];
            maxIndex = i;
        
        }
    
    }

    return maxIndex;
    }
 public int[] countLetters(String message){ 
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    int[] counts = new int[26];
    
        for(int k=0; k < message.length(); k++){
        char ch = Character.toLowerCase(message.charAt(k));
        int dex = alpha.indexOf(ch);
        
        if(dex != -1){
        
            counts[dex] += 1;
        }
    
    }
    
    return counts;
    }


public void testDecrypt(){
    //Ede's Pickles are very very tastee with a key of 7
    String message = "Lkl'z Wpjrslz hyl clyf clyf ahzall";
    
    String decryptedMessage=decrypt(message);
        
    System.out.println(message + " has a dkey key of " + decryptedMessage);
}

/*
Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start. 
This method should return a new String that is every other character from message starting with the start position. 
For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1)
 returns the String “bmZi”. Be sure to test this method with a small example.
 */

public String halfOfString(String message, int start){
    
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(int k=start; k < message.length(); k+=2){
                char ch = message.charAt(k);
                sb.insert(i, ch);
                i += 1;
            
            }
            
            return sb.toString(); 
}

public void testhalfOfString(){
    String sb = halfOfString("Qbkm Zgis", 0);   
    
    System.out.println(sb);
    System.out.println("“Qk gs”");
    String sb2 = halfOfString("Qbkm Zgis", 1);
    
    System.out.println(sb2);
    System.out.println("bmZi");
}


/*
 * Write the method getKey in the CaesarBreaker class that has one parameter, a String s. This method should call countLetters to get an array of the letter 
 * frequencies in String s and then use maxIndex to calculate the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, 
 * which leads to the key, which is returned.
 */
public int getKey(String s){
   int[] freqs = countLetters(s);
   int maxIndex = maxIndex(freqs);
   
    int dkey;
       
        dkey = maxIndex - 4;
        
        if (maxIndex < 4) {
            dkey = 26 - (4-maxIndex);
        
        }
        return dkey;
}

/*
 *     Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, a String parameter named encrypted that represents a 
 *     String that was encrypted with the two key algorithm discussed in the previous lesson. This method attempts to determine the two keys used
 *     to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys. More specifically, this method should:

        - Calculate a String of every other character starting with the first character of the encrypted String by calling halfOfString. 

        - Calculate a String of every other character starting with the second character of the encrypted String. 

        - Then calculate the key used to encrypt each half String.

        - You should print the two keys found.

        - Calculate and return the decrypted String using the encryptTwoKeys method from your CaesarCipher class, 
        again making sure it is in the same folder as your CaesarBreaker class.


 */

public void decryptTwoKeys(String encrypted){
    String firstHalf = halfOfString(encrypted, 0);
    String secondHalf = halfOfString(encrypted, 1);
    
    int firstHalfKey = getKey(firstHalf);
     System.out.println("First key is: " + firstHalfKey);
    int secondHalfKey = getKey(secondHalf);
     System.out.println("Second key is: " + secondHalfKey);
     
     CaesarCipher cc = new CaesarCipher();
     
     String messageFirstHalf = cc.encrypt(firstHalf, 26-firstHalfKey);
    
    String messageSecondtHalf = cc.encrypt(secondHalf, 26-secondHalfKey);
    
    StringBuilder sb = new StringBuilder();
    int j = 0;
    int i = 0;
    for(int k=0; k < encrypted.length(); k++){
               if(k%2 == 0){
                 char ch = messageFirstHalf.charAt(j);
                 sb.insert(k, ch);
                j += 1;
                
                }
                else{
                char ch = messageSecondtHalf.charAt(i);
                sb.insert(k, ch);
                i += 1;
                }
              
            
            }
            
    System.out.println(sb.toString());

}

public void testDecryptTwoKeys(){
decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");

}

}
