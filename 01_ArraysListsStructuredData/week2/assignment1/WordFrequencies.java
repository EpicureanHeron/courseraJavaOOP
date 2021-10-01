
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import  java.util.*;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class WordFrequencies {
    
    /*
    You should identify a speaking part by reading the file line-by-line and finding the location of the first period on the line. 
    Then you will assume that everything up to the first period is the name of a character and count how many times that occurs in the file.  * 
     * 
     */
    
    /*
     * Create two private variables. One is called myWords and should be an ArrayList of type String to store unique words 
     * from a file, and one is called myFreqs and should be an ArrayList of type Integer. The kth position in 
     * myFreqs should represent the number of times the kth word in myWords occurs in the file. 
     */
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    /*
     * Write a constructor WordFrequencies, and initialize the private variables. 
     */
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    /*
     * Write a void method findUnique that has no parameters. This method should first clear both myWords and myFreqs, 
     * using the .clear() method. Then it selects a file and then iterates over every word in the file, putting the unique
     * words found into myWords. For each word in the kth position of myWords, it puts the count of how many times that word 
     * occurs from the selected file into the kth position of myFreqs, as was demonstrated in the lesson.
     */
    
    public void findUnique(){
    
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s: resource.words()){
        s = s.toLowerCase();
        int index = myWords.indexOf(s);
        if (index == -1){
            myWords.add(s);
            myFreqs.add(1);
        }
        else{
            int value = myFreqs.get(index);
            myFreqs.set(index, value + 1);
        }
        }
        
        System.out.println("Total unique words: " + myWords.size()); 
    }
    
    
    /*
     * Write a void tester method that has no parameters. This method should call findUnique. Then print out the number of unique words, 
     * and for each unique word, print the frequency of each word and the word, as was demonstrated in the lesson.
     */
    public void test(){
        findUnique();
        for(int k=0; k < myWords.size(); k++){
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        }
        
        int maxIndex = findIndexOfMax();
        
        System.out.println(myFreqs.get(maxIndex) + "\t" + myWords.get(maxIndex));
    }
    
    /*
     * Write the method findIndexOfMax that has no parameters. This method returns
     * an int that is the index location of the largest value 
     * in myFreqs. If there is a tie, then return the first such value.
     */

    public int findIndexOfMax(){
        int maxIndex = -1;
        int maxValue = -1;
        for(int k=0; k < myWords.size(); k++){
            
            int currVal = myFreqs.get(k);;
            
            if(currVal > maxValue){
                maxValue = currVal;
                maxIndex = k;
            
            }
        
        }
        
        return maxIndex;
    }
    /*
     * Add code to the tester method to determine and print the word that occurs the most often in 
     * a selected file and how many times it occurs. You should find it helpful to call findIndexOfMax.
     */
}

