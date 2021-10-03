
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordsInFiles {
        //Create a private variable to store a HashMap 
    //that maps a word to an ArrayList of filenames.
    private HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

    public WordsInFiles(){
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    }
    
    /*
     * Write a private void method named addWordsFromFile that has one parameter f 
     * of type File. This method should add all the words from f into the map. If a 
     * word is not in the map, then you must create a new ArrayList of type String with 
     * this word, and have the word map to this ArrayList. If a word is already in the map,
     * then add the current filename to its ArrayList, unless the filename 
     * is already in the ArrayList. You can use the File method getName to get the filename
     * of a file. 
     */
    
    private void addWordsFromFile(File f){
    
       FileResource resource = new FileResource(f);
       for(String word : resource.words()){
           //check to see if word exists as key in map
           if(map.containsKey(word)){
               //check to see if file exists in array value
               if(!map.get(word).contains(f.getName())){
                   //if the list at the value for the key
                   // does not contain the file name, add the file name
                   map.get(word).add(f.getName());
                }
                //else...we continue so not else clause
            
            }
            //if the map does not contain the word
            else{
                // create a new array list to store the file names
                 ArrayList<String> fileList = new ArrayList<String>();
                 // add the file name to the list
                 fileList.add(f.getName());
                 // put the new key  value pair into the map. 
                 map.put(word, fileList);
                 
            }
        
        
        }

}
    
    /*
     * Write a void method named buildWordFileMap that has no parameters. This 
     * method first clears the map, and then uses a DirectoryResource to select a 
     * group of files. For each file, it puts all of its words into the map by calling 
     * the method addWordsFromFile. 
     * The remaining methods to write all assume that the HashMap has been built.

     */
    
    public void buildWordFileMap(){
    map.clear();
    DirectoryResource dr = new DirectoryResource();
    
    for (File f : dr.selectedFiles()){
        addWordsFromFile(f);
    
    }
    
    }
    
    /*
     * Write the method maxNumber that has no parameters. This method returns the maximum
     * number of files any word appears in, considering all words from a group of files. 
     * In the example above, there are four files considered. No word appears in all four 
     * files. Two words appear in three of the files, so maxNumber on those 
     * four files would return 3. This method assumes that the HashMap has already been 
     * constructed.
     * 
     * 
     */
    
    public int maxNumber(){
    int maxValue = 0;
    String maxKey = "n/a";
    System.out.println("Most common");
    for(String w: map.keySet()){
        ArrayList<String> currValue = map.get(w);
        int currLen = currValue.size();
        if(currLen > maxValue){
            maxValue = currLen;
            maxKey = w;
            
        }
    
    }
    System.out.println(maxKey + " has a total of " + maxValue + " which is the most common for this iteration");
    return maxValue;
    
    }
    
    /*
     * Write the method wordsInNumFiles that has one integer parameter called number. 
     * This method returns an ArrayList of words that appear in exactly number files.
     * In the example above, the call wordsInNumFiles(3) would return an ArrayList with 
     * the words  “cats” and “and”, and the call wordsInNumFiles(2) would return an ArrayList 
     * with the words “love”, “are”, and “dogs”, all the words that appear in exactly two
     * files.
     */
    
    public ArrayList wordsInNumFiles(int number){
           ArrayList<String> wordsMatching = new ArrayList<String>();
           
              for(String w: map.keySet()){
                ArrayList<String> currValue = map.get(w);
                int currLen = currValue.size();
                if(currLen == number){
                    wordsMatching.add(w);
            
        }
    
    }
        return wordsMatching;
    }
    
    /*
     * Write the void method printFilesIn that has one String parameter named word. 
     * This method prints the names of the files this word appears in, one filename 
     * per line. For example, in the example above, the call printFilesIn(“cats”) would 
     * print the three filenames: brief1.txt, brief3.txt, and brief4.txt, each on a 
     * separate line.
     * 
     */
    
    public void printFilesIn(String word){
        ArrayList<String> words = map.get(word);
        System.out.println("printing all files for word: " + word); 
        for(int i = 0; i < words.size(); i++){
        
            System.out.println(words.get(i)); 
        }
    }
    
    /*
     * Write the void method tester that has no parameters. This method should call 
     * buildWordFileMap to select a group of files and build a HashMap of words, with 
     * each word mapped to an ArrayList of the filenames this word appears in, determine 
     * the maximum number of files any word is in, considering all words, and determine
     * all the words that are in the maximum number of files and for each such word, print
     * the filenames of the files it is in. (optional) If the map is not too big, then you
     * might want to print out the complete map, all the keys, and for 
     * each key its ArrayList. This might be helpful to make sure the map was built correctly.
     */
    
    public void tester(){
   
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> wordsMatching = wordsInNumFiles(4);
        
        for(int i = 0; i < wordsMatching.size(); i++){
            printFilesIn(wordsMatching.get(i));
    
    }
    System.out.println("total words with higest value " + wordsMatching.size());
    
    printFilesIn("sea");
    
    printFilesIn("tree");
}
}
