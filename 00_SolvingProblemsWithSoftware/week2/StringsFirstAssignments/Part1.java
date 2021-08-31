
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;
public class Part1 {
    public String findSimpleGene(String dna) {
 
        String startCodon = "ATG";
        String endCodon = "TAA";    
        
        String result = "";
        
        int startIndex = dna.indexOf(startCodon);
        
        if(startIndex == -1){
            return "";
        }
        
         int endIndex = dna.indexOf(endCodon, startIndex + 3);
        
        if(endIndex == -1){
            return "";
        }
        result = dna.substring(startIndex, endIndex+ 3) ;
        
        return result;
        
};
public void testSimpleGene(){
    String dna = "ATGFADFDADDFTAAFDFSDFD";
    System.out.println("DNA is the following" + dna);
    
    String gene = findSimpleGene(dna);
    System.out.println("Gene is the following" + gene);
    
    
    
};

};  
