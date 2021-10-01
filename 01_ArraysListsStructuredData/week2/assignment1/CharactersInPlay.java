
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import  java.util.*;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CharactersInPlay {

    /*
     * 
     * You will need to create two private ArrayLists. One to store the the
     * names of the characters you find and one to store the corresponding counts
     * for each character. 
     */
    private ArrayList<String> charactersArr;
    private ArrayList<Integer> charFreqs;
    
    public CharactersInPlay(){
        charactersArr = new ArrayList<String>();
        charFreqs = new ArrayList<Integer>();
    }
    
    
    /*
     * Write a void method named update that has one String parameter named person. 
     * This method should update the two ArrayLists, adding the character’s name if it 
     * is not already there, 
     * and counting this line as one speaking part for this person. 
     */
    public void update(String person){

            int index = charactersArr.indexOf(person);
            if (index == -1){
                charactersArr.add(person);
                charFreqs.add(1);
            }
            else{
                int value = charFreqs.get(index);
                charFreqs.set(index, value + 1);
            }
            }
            
  
    /*
     * Write a void method called findAllCharacters that opens a file, and reads the 
     * file line-by-line. For each line, if there is a period on the line, extract the 
     * possible name of the speaking part, and call update to count it as an occurrence
     * for this person. 
     * Make sure you clear the appropriate instance variables before each new file.
     */
    public void findAllCharacters(){
        charactersArr.clear();
        charFreqs.clear();
        FileResource resource = new FileResource();
        for(String line: resource.lines()){
            int firstPeriodIndex = line.indexOf(".");
            if(firstPeriodIndex != -1){
                String currChar = line.substring(0, firstPeriodIndex);
                update(currChar);
            }
            
    }
}
    /*
     * Write a void method called tester that has no parameters. This method should 
     * call findAllCharacters, and then for each main character, print out the main 
     * character, followed by the number of speaking parts that character has. A main 
     * character is one who has more speaking parts than most people. 
     * You’ll have to estimate what that number should be. Test your method on the file 
     * 
     */
    
    public void tester(){
    findAllCharacters();
    for(int k=0; k < charactersArr.size(); k++){
            System.out.println(charFreqs.get(k) + "\t" + charactersArr.get(k));
        }
        
    int maxIndex = findIndexOfMax();
    
    System.out.println(charFreqs.get(maxIndex) + "\t" + charactersArr.get(maxIndex));
    }
    
        public int findIndexOfMax(){
        int maxIndex = -1;
        int maxValue = -1;
        for(int k=0; k < charactersArr.size(); k++){
            
            int currVal = charFreqs.get(k);;
            
            if(currVal > maxValue){
                maxValue = currVal;
                maxIndex = k;
            
            }
        
        }
        
        return maxIndex;
    }
    
    /*
     * Write a void method called charactersWithNumParts that has two int parameters named
     * num1 and num2, where you can assume num1 should be less than or equal to num2. This method
     * should print out the names of all those characters that have exactly number speaking parts, where number
     * is greater than or equal to num1 and less than or equal to num2. Add code in tester to test this method out.
     */
    
    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters with greater than or equal to " + num1);
        for(int k=0; k < charactersArr.size(); k++){
            if(charFreqs.get(k) >= num1 && charFreqs.get(k) <= num2 ){
                System.out.println(charFreqs.get(k) + "\t" + charactersArr.get(k));
            }
            
        }
        System.out.println("Characters with equal to " + num2);
                for(int i=0; i < charactersArr.size(); i++){
            if(charFreqs.get(i) == num2){
                System.out.println(charFreqs.get(i) + "\t" + charactersArr.get(i));
            }
            
        }
    
    }
    
    public void testCharWithNumParts(){
        findAllCharacters();
        charactersWithNumParts(10,15);
    
    }
}
