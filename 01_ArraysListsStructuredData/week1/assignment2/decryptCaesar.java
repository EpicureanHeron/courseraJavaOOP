
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
 * You should start by writing the decryption method explained in the 
 * lesson that decrypts a message that was encrypted with one key, using 
 * statistical letter frequencies of English text. Then you will add code 
 * to be able to decrypt a message that was encrypted with two keys, using ideas 
 * from the single key decryption method and the encryption with two keys method from 
 * the program you wrote in the last lesson.
 */

   public int decrypt(String message){
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    
    int[] counts = new int[26];
    int dkey;
    
    for(int k=0; k < message.length(); k++){
        char ch = Character.toLowerCase(message.charAt(k));
        int dex = alpha.indexOf(ch);
        
        if(dex != -1){
        
            counts[dex] += 1;
        }
    
    }
    
    int maxValue = 0;
    int maxIndex = 0;
    
    for(int i=0; i < counts.length; i++){
        if(counts[i] > maxValue){
            maxValue = counts[i];
            maxIndex = i;
        
        }
    
    }
    dkey = maxIndex - 4;
    
    if (maxIndex < 4) {
        dkey = 26 - (4-maxIndex);
    
    }
    
    return dkey;
}

/*
 * dea for two keys decrypt method. Recall that in using two keys, key1 and key2,
 * key1 was used to encrypt every other character, starting with the first, of the 
 * String, and key2 was used to encrypt every other character, starting with the second. 
 * In order to decrypt the encrypted String, it may be easier to split the String into two 
 * Strings, one String of all the letters encrypted with key1 and one String of all the letters 
 * encrypted with key2. Then use the algorithm from the lesson to determine the key for each String, 
 * and then use those keys and the two key encryption method to decrypt the original encrypted message.
 */

}
