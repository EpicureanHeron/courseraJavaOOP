 import java.util.*;
import edu.duke.*;
import edu.duke.*;
import java.io.File;

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
        HashMap <String, HashSet<String>> langsHash = new HashMap<String, HashSet<String>>();
        //directory resource
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            HashSet<String> dict = readDictionary(file);
            langsHash.put(f.getName(), dict); 

       
        
        
    }
    FileResource fr2 = new FileResource();
    String encrypted = fr2.asString();
        
    String decrypted = breakForAllLangs(encrypted, langsHash);
        
   // System.out.println(decrypted);
}
    /*
     * In the VigenereBreaker class, write the public method readDictionary, 
     * which has one parameter—a FileResource fr. This method should first make 
     * a new HashSet of Strings, then read each line in fr (which should contain exactly 
     * one word per line), convert that line to lowercase, and put that line into the HashSet 
     * that you created. The method should then return the HashSet representing the words in a dictionary.
     * All the dictionary files, including the English dictionary file, are included in the starter program you download.
     * They are inside the folder called ‘dictionaries’.
     */
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<String>();
        
        for(String line : fr.lines()){
            String lowerCase = line.toLowerCase();
            dictionary.add(lowerCase); 
        }
        
        return dictionary;
    }
    
    public void testreadDictionary(){
        FileResource fr = new FileResource();
        HashSet<String> dict = readDictionary(fr);
        
        dict.forEach(System.out::println);
    
    
    }
    
    /*
     * In the VigenereBreaker class, write the public method countWords, which has two parameters—a String message, 
     * and a HashSet of Strings dictionary. This method should split the message into words (use .split(“\\W+”), which
     * returns a String array), iterate over those words, and see how many of them are “real words”—that is, how many
     * appear in the dictionary. Recall that the words in dictionary are lowercase. This method should return the integer
     * count of how many valid words it found.
     */
    
    public int countWords(String message, HashSet<String> dictionary){
        int count = 0;
        //https://stackoverflow.com/questions/28802445/java-string-split-trouble-using-w-as-non-word-delimiter
        String[] words = message.split("\\W+");
        
        for(String word: words){
            String lower_word = word.toLowerCase();
            if (dictionary.contains(lower_word)){
                count += 1;
            }
        
        }
        
        return count;
    }
    
    public void testCountWords(){
        FileResource fr = new FileResource();
        HashSet<String> dict = readDictionary(fr);
        FileResource fr2 = new FileResource();
        String encrypted = fr2.asString();
        
        int count = countWords(encrypted, dict); 
        System.out.println(count);
    }
    
    /*
     * In the VigenereBreaker class, write the public method breakForLanguage, which has two 
     * parameters—a String encrypted, and a HashSet of Strings dictionary. This method should 
     * try all key lengths from 1 to 100 (use your tryKeyLength method to try one particular key length) 
     * to obtain the best decryption for each key length in that range. For each key length, your method 
     * should decrypt the message (using VigenereCipher’s decrypt method as before), and count how many of 
     * the “words” in it are real words in English, based on the dictionary passed in (use the countWords 
     * method you just wrote). This method should figure out which decryption gives the largest count of real 
     * words, and return that String decryption. Note that there is nothing special about 100; we will just give 
     * you messages with key lengths in the range 1–100. If you did not have this information, you could iterate 
     * all the way to encrypted.length(). Your program would just take a bit longer to run.
     */
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary, char mostCommon){
    //char mostCommon = 'e';
    int maxValue = 0;
    int keyLength = 0;

    for(int i = 1; i <= 100; i+=1){
       int[] key = tryKeyLength(encrypted, i, mostCommon);
       VigenereCipher vc = new VigenereCipher(key);
       String decrypted = vc.decrypt(encrypted);
       int wordCount = countWords(decrypted, dictionary);
       if(wordCount > maxValue){
         maxValue = wordCount;
         keyLength = i;
        }
        
     
    }
    int[] bestKey = tryKeyLength(encrypted, keyLength, mostCommon);
    VigenereCipher vc = new VigenereCipher(bestKey);
    String decrypted = vc.decrypt(encrypted);
    System.out.println("key is this long: " + bestKey.length);
    return decrypted;
    }
    
    /*
     * In the VigenereBreaker class, write the public method mostCommonCharIn, which has one parameter—a HashSet 
     * of Strings dictionary. This method should find out which character, of the letters in the English alphabet, 
     * appears most often in the words in dictionary. It should return this most commonly occurring character. Remember 
     * that you can iterate over a HashSet of Strings with a for-each style for loop.
     */
    public char mostCommonCharIn(HashSet<String> dictionary){
        
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>(); 
        
        for(String word: dictionary){
            
            for(int i =0; i < word.length(); i+= 1){
                char currentChar = word.charAt(i);
                
                if(!charMap.containsKey(currentChar)){
                    charMap.put(currentChar, 1);
                
                }
                else{
                    charMap.put(currentChar, charMap.get(currentChar) + 1);
                }
            }

       
        }
        int maxValue = 0;
        char maxChar = ' '; 
        
        for(char c : charMap.keySet()){
            
            if(charMap.get(c) > maxValue){
                maxValue = charMap.get(c);
                maxChar = c; 
            
            }
        }
        return maxChar; 
    }
    
   /*
    *   In the VigenereBreaker class, write the public method breakForAllLangs, which has two parameters—a String encrypted, and a HashMap, 
    *   called languages, mapping a String representing the name of a language to a HashSet of Strings containing the words in that language.
    *   Try breaking the encryption for each language, and see which gives the best results! Remember that you can iterate over the languages.keySet()
    *   to get the name of each language, and then you can use .get() to look up the corresponding dictionary for that language. You will want to use the 
    *   breakForLanguage and countWords methods that you already wrote to do most of the work (it is slightly inefficient to re-count
    *   the words here, but it is simpler, and the inefficiency is not significant). You will want to print out the decrypted message as well as the language
    *   that you identified for the message.
    */
   public String breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
           int maxValue = 0;
           String maxLang = " ";
       for(String lang: languages.keySet()){
           char mostCommonInLang = mostCommonCharIn(languages.get(lang));
           String decrypted = breakForLanguage(encrypted, languages.get(lang), mostCommonInLang);
           
           int totalCount = countWords(decrypted, languages.get(lang));
           
           if(totalCount > maxValue){
            maxValue = totalCount;
            maxLang = lang;
            }
            
        }
        char mostCommonInLang = mostCommonCharIn(languages.get(maxLang));
        String decrypted = breakForLanguage(encrypted, languages.get(maxLang), mostCommonInLang);
        System.out.println(decrypted);
        System.out.println(maxLang);
        
        return decrypted;
    }
}
