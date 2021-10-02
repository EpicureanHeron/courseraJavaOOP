
/**
 * Write a description of codonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class codonCount {
    //Create a private variable to store a HashMap to map DNA codons to their count.
   private HashMap<String,Integer> map = new HashMap<String,Integer>();
   
   //Write a constructor to initialize the HashMap variable.
   public codonCount(){
       HashMap<String,Integer> map = new HashMap<String,Integer>();
    }
    /*
     * Write a void method named buildCodonMap that has two parameters, an int named
     * start and a String named dna. This method will build a new map of codons mapped
     * to their counts from the string dna with the reading frame with the position start 
     * (a value of 0, 1, or 2).
     * You will call this method several times, so make sure your map is empty before 
     * building it.
     */
    
    
   public void buildCodonMap(int start, String dna){
    
    }
    
    /*
     * Write a method named getMostCommonCodon that has no parameters. This method 
     * returns a String, the codon in a reading frame that has the largest count. If
     * there are several such codons, return any one of them. 
     * This method assumes the HashMap of codons to counts has already been built.
     */
    
   public String getMostCommonCodn(){
    
    return "0";
    }
    
    /*
     * Write a void method named printCodonCounts that has two int parameters, start and 
     * end. This method prints all the codons 
     * in the HashMap along with their counts if their count is between start and end,
     * inclusive.
     * 
     */
   public void printCodonCounts(int start, int end){
    
    } 
    /*
     * Write a tester method that prompts the user for a file that contains a DNA strand 
     * (could be upper or lower case letters in the file, convert them all to uppercase, 
     * since case should not matter). Then for each of the three possible reading frames, 
     * this method builds a HashMap of codons to their number of occurrences in the DNA 
     * strand, prints the total number of unique codons in the reading frame, prints the
     * most common codon and its count, and prints the codons and their number of occurrences 
     * for those
     * codons whose number of occurrences in this reading frame are between two numbers
     * inclusive.
     */
   public void tester(){
    
    }
}
