
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import edu.duke.*;
import java.io.File;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String endCodon) {
 
        String result = "";
        
        if(dna.equals(dna.toUpperCase())){
            startCodon = startCodon.toUpperCase();
            endCodon = endCodon.toUpperCase();
        }
        else{
            startCodon = startCodon.toLowerCase();
            endCodon = endCodon.toLowerCase();
        }
        
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
    System.out.println("DNA is the following " + dna);
    
    String gene = findSimpleGene(dna, "ATG", "AAF");
    System.out.println("Gene is the following " + gene);
    
    
    dna = "atgabcadgervadfdadf";
    System.out.println("DNA is the following " + dna);
    
    gene = findSimpleGene(dna, "ABC", "DAD");
    System.out.println("Gene is the following " + gene);
    
    
    
    
};

        
}
