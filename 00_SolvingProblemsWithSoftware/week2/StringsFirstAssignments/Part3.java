
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        stringa = stringa.toLowerCase();
        stringb = stringb.toLowerCase();
        int occCount = 0;
        int currIndex = stringb.indexOf(stringa);
        
        while(currIndex != - 1){
            occCount += 1;
            currIndex =  stringb.indexOf(stringa, currIndex + stringa.length());
            
        }
        
        if(occCount >= 2){
         return true;
         
        }
        
        else{
        return false; 
    }
    
    
    
    }
    public String lastPart(String stringa, String stringb){
        int currIndex = stringb.indexOf(stringa);
        
        if(currIndex == -1){
            return stringb;
        }
        
        String lastPartString = stringb.substring(currIndex + stringa.length());
        
        return lastPartString;
        
        
        
    }
    public void testTwoOccurences(){
            String dna = "ATGFADFDADDFTAAFDFSDFD";
            String letter = "A";
            System.out.println("string a is the following: " + letter);
            System.out.println("string b is the following: " + dna);
    
            Boolean gene =  twoOccurrences(letter, dna);
            System.out.println("String B occurs in String A two or more times: " + gene);
            
            String a = "zoo";
            String b = "forest";
            
            String lastPartString = lastPart(a, b);
            
            System.out.println("Last Part of String a in String B: " + lastPartString);
    
    }
    
}
