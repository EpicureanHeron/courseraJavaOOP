
/**
 * Write a description of findingManyGenes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class findingManyGenes {
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        
//find first ATG in dna
    String startCodon = "ATG";
    int startCodonIndex = dna.indexOf(startCodon, startIndex);
    
//find first stopCodon
    int endCodonIndex = dna.indexOf(stopCodon, startCodonIndex + 3);
    
    int diffInCodons = endCodonIndex - startCodonIndex;
    
    if(diffInCodons % 3 == 0){
    return endCodonIndex;
    }

        
        return dna.length();
    }
    //part 1 section 5
    public String findGene(String dna){
    
    
    return "";
    
    }
    
    public void testFindStopCodon(){
    
        String dna = "ATGaaaFATaaa";
        
        int indexOfStop = findStopCodon(dna, 0, "FAT");
        
        
        System.out.println("dna string is: " + dna);
        System.out.println("indexOfStop  is: " + indexOfStop);
        
        
        dna = "aaATGaaaafFATaaa";
        
        indexOfStop = findStopCodon(dna, 0, "FAT");
        
        
        System.out.println("dna string is: " + dna);
        System.out.println("indexOfStop  is: " + indexOfStop);
    
    
    }
    
    
    
    
    
    
    

}
