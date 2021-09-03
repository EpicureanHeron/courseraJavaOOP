
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
    int endCodonIndex = dna.indexOf(stopCodon, startCodonIndex);
    
    int diffInCodons = endCodonIndex - startCodonIndex;
    System.out.println("stop codon " + stopCodon);
    System.out.println("diff in codons " + diffInCodons);
    if(diffInCodons % 3 == 0){
    return endCodonIndex;
    }

        
        return dna.length();
    }
    //part 1 section 5
    public String findGene(String dna){
        
   
        int indexATG = dna.indexOf("ATG");
        if(indexATG == -1){
            return "";
        }
        int indexTAA = findStopCodon(dna, indexATG, "TAA");
        System.out.println("TAA string is: " + indexTAA);
        int indexTAG = findStopCodon(dna, indexATG, "TAG");
        System.out.println("TAG string is: " + indexTAG);
        int indexTGA = findStopCodon(dna, indexATG, "TGA");
        System.out.println("TGA string is: " + indexTGA);
        
        int temp = Math.min(indexTAA, indexTAG);
        
        int stopCodonMin = Math.min(temp, indexTGA);
        
        if(dna.length() == stopCodonMin){
         return "";   
        }
        
        return dna.substring(indexATG, stopCodonMin);
    
        
    
    }
    
    public void testFindStopCodon(){
    
        String dna = "ATGATAAATGAATGAATG";
        System.out.println("dna string is: " + dna);
        int indexOfStop = findStopCodon(dna, 0, "TGA");
        
        
        
        System.out.println("indexOfStop  is: " + indexOfStop);
        
        
        dna = "aaATGaaaafFATaaa";
        
        indexOfStop = findStopCodon(dna, 0, "FAT");
        
        
        System.out.println("dna string is: " + dna);
        System.out.println("indexOfStop  is: " + indexOfStop);
    
    
    }
    
    public void testFindGene(){
        String dna = "ATGATAAATGAATGAATG";
        System.out.println("dna string is: " + dna);
        //should return ATGATAAATGAATGA
        String geneResult = findGene(dna);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        dna = "ATGAAAATAGATGAATAGTAA";
        //should return ATGTGA
        geneResult = findGene(dna);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        dna = "TGATAGTAA";
        // should return ""
        geneResult = findGene(dna);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        
    }
    
    
    
    
    
    
    

}
