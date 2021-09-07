
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        startIndex = dna.indexOf("ATG", startIndex);
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
        }
        return dna.length();
    }
    

    //part 1 section 5
    public String findGene(String dna, int startIndex){
        int atgCodon = dna.indexOf("ATG", startIndex);
        
        if (atgCodon == -1) {
            return "";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int tempCodon = Math.min(taaCodon, tagCodon);
        int dnaFin = Math.min(tempCodon, tgaCodon);
        if (dnaFin == dna.length()) {
            return "";
        }
        System.out.println("atg  is: " + atgCodon);
        System.out.println("dnaFin  is: " + dnaFin);
        System.out.println("gene  is: " + dna.substring(atgCodon, dnaFin+3));
        return dna.substring(atgCodon, dnaFin+3);
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
        String geneResult = findGene(dna, 0);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        dna = "ATGAAAATAGATGAATAGTAA";
        //should return ATGTGA
        geneResult = findGene(dna, 0);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        dna = "TGATAGTAA";
        // should return ""
        geneResult =findGene(dna, 0);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
         dna = "TGATAGTAA";
        // should return ""
        geneResult = findGene(dna, 0);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        dna = "ATGATAAATGAATAAATG";
        System.out.println("dna string is: " + dna);
        //should return ATGATAAATGAATAA
       geneResult = findGene(dna, 0);
        System.out.println("dna string is: " + dna);
        System.out.println("gene is: " + geneResult);
        
        
    }
    
    
    public void printAllGenes(){
        String dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaaTAGaTAGaaTAGaaTAG"; 
        
        int startIndex = 0;
        while (true){
            System.out.println("start index: " + startIndex);
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
        

   }
   
       public int countGenes(String dna){
        
        int count = 0;
        int startIndex = 0;
        while (true){
            System.out.println("start index: " + startIndex);
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
            count = count + 1;
        }
        
        return count;
   }
   
   public void testCountGenes(){
       String dna = "ATGAAATGAGATGAAAAAATAG";
       int results =  countGenes(dna);
       System.out.println("count of dna " + results);
    }
}
