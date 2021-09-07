
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class Part1 {
    
    
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
    
        public  StorageResource getAllGenes(String dna){
        //String dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaaTAGaTAGaaTAGaaTAG"; 
        StorageResource store = new StorageResource();
        int startIndex = 0;
        while (true){
            //System.out.println("start index: " + startIndex);
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println("gene: " + currentGene);
            store.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
        return store;
    }
    
    public void testgetAllGenes(){
        StorageResource store = getAllGenes("aaaaaaATGaaaaaaaaaTAGTTATGAaaaTAGaTAGaaTAGaaTAG");
        
        for (String s: store.data()){
            System.out.println(s);
        }
    
    
    }
    
    public double cgRatio(String dna){
    int cCount = howMany("C", dna);
    
    int gCount = howMany("G", dna);
    
    double cDouble = cCount;
    double gDouble = gCount;
    
    double result = (cDouble + gDouble)/dna.length();
    
    return result;
    
    }
    
    public void testcgRatio(){
    String dna= "aaaCCCCaaaATGaaaaaaaaaTAGTTATGAaaaTAGaTAGaaTAGaaTAG"; 
    
    double results = cgRatio(dna);
    
    System.out.println("result: " + results);
    
    
    }
    
    public int howMany(String stringa, String stringb){
    int count = 0;
    int startIndex = 0;
    while(true){
    
    int stringStart = stringb.indexOf(stringa, startIndex);
    
    if(stringStart == -1){
        break;
    }
    count = count + 1;
   // System.out.println("count:  " + count);
    startIndex = stringb.indexOf(stringa, startIndex) + stringa.length();
    
    }
    
    
    
    return count;
    }
    
    
    public void processGenes(){
       // FileResource fr = new FileResource("brca1line.fa");
        FileResource fr = new FileResource("GRch38dnapart.fa");
	String dna = fr.asString().toUpperCase();
	StorageResource sr = getAllGenes(dna);
        int totalGenes = 0;
        int threshold = 60;
        int longerThanThreshold = 0;
        double cgRatioThershold = 0.35;
        int cgCount = 0;
        int longest = 0;
        String longestString = "";
    
        for(String s: sr.data()){
        totalGenes = totalGenes + 1;
        if(s.length() > threshold){
            System.out.println("the following string is longer than threshold:  " + s);
            longerThanThreshold = longerThanThreshold + 1;
        }
        
        double cgResult = cgRatio(s);
        
        if(cgResult > cgRatioThershold){
         System.out.println("the following string is greater CG ratio threshold:  " + s);
         cgCount = cgCount + 1;
        }
        
        if (s.length() > longest){
            longest = s.length();
            longestString = s;
        
        }
        
               
        }
        System.out.println("Total strings greater than threshold:  " + longerThanThreshold);
        System.out.println("Total strings with CG than threshold:  " + cgCount);
        System.out.println("Longest String: " + longestString);
        System.out.println("Longest String length: " + longest);
        System.out.println("Total Genes: " + totalGenes);
    
    }
    

}

