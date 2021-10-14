import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    
    /*
     * Write the public method sliceString, which has three parameters—a String message, 
     * representing the encrypted message, an integer whichSlice, indicating the index 
     * the slice should start
     * from, and an integer totalSlices, indicating the length of the key. This method returns 
     * a String consisting of every totalSlices-th character from message, starting at the 
     * whichSlice-th character.
     */
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        
        StringBuilder messageSB = new StringBuilder(message);
        StringBuilder slice = new StringBuilder();
        
        for(int i = whichSlice; i < message.length(); i += totalSlices){
            char currSlice = messageSB.charAt(i);
            slice.append(currSlice);

        }
        
        
        return slice.toString();
    }
    
    
    /*
     * Write the public method tryKeyLength, which takes three parameters—a String encrypted 
     * that represents the encrypted message, an integer klength that represents the key length, 
     * and a character mostCommon that indicates the most common character in the language of the message. 
     * This method should make use of the CaesarCracker class, as well as the sliceString method, to find 
     * the shift for each index in the key. You should fill in the key (which is an array of integers) and return it. 
     * Test this method on the text file athens_keyflute.txt, which is a scene from A Midsummer Night’s Dream encrypted
     * with the key “flute”, and make sure you get the key {5, 11, 20, 19, 4}.
     */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        for(int i=0; i < klength; i+= 1){
            String encryptedSlice = sliceString(encrypted, i, klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            
            int dkey = cc.getKey(encryptedSlice);
            key[i] = dkey;
           
        }
        
        return key;
    }
    
    /*
     *     
     *     Create a new FileResource using its default constructor (which displays a dialog for you to select a file to decrypt).

    Use the asString method to read the entire contents of the file into a String.

    Use the tryKeyLength method, which you just wrote, to find the key for the message you read in. For now, you should just pass ‘e’ for mostCommon.

    You should create a new VigenereCipher, passing in the key that tryKeyLength found for you.

    You should use the VigenereCipher’s decrypt method to decrypt the encrypted message.

    Finally, you should print out the decrypted message!
     */
    
    public void breakVigenere () {
       FileResource fr = new FileResource();
       String encrypted = fr.asString();
       int[] key = tryKeyLength(encrypted, 5, 'e');
       
       VigenereCipher vc = new VigenereCipher(key);
       String decrypted = vc.decrypt(encrypted);
       System.out.println(decrypted); 
    }
    
    public void testSliceString(){
        String test = sliceString("abcdefghijklm", 0, 3);
        
        System.out.println(test);
        
        String test2 = sliceString("abcdefghijklm", 1, 5);
        System.out.println(test2);
    }
    
    public void testTryKeyLength(){
     FileResource fr = new FileResource();
        String encrypted = fr.asString();
        int[] key = tryKeyLength(encrypted, 5, 'e');
        for (int i=0; i < 5; i++) {
            System.out.print(key[i] + " ");
        }
    
    
    }
    
}
