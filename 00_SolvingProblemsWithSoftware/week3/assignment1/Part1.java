
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    
    public CSVParser tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        return parser;
    }
    
    public String countryInfo(CSVParser parser, String country){
        
        String results = "";
        
        for(CSVRecord record: parser){
        
        String countryRow = record.get("Country");
        
        if(countryRow.contains(country)){
           
            String exports = record.get("Exports");
            String value = record.get("Value (dollars)");

            results = country + ": " + exports + ": " + value;
            
        }
        
        }
        return results;
    }
    
    public void testCountryInfo(){
        CSVParser parser = tester();
        String country = "Peru";
        String results = countryInfo(parser, country);
        System.out.println(results);
        
        parser = tester();
        country = "Nauru";
        results = countryInfo(parser, country);
        System.out.println(results);
        
    
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
    for(CSVRecord record: parser){
         String ex1 = exportItem1.toLowerCase();
         String ex2 = exportItem2.toLowerCase();
         String exportCell = record.get("Exports");
         
         if(exportCell.contains(ex1) && exportCell.contains(ex2)){
            String country = record.get("Country");
            System.out.println(country);
            
            }
         
         
    
    }
    
}

 public void testlistExportersTwoProducts(){
      CSVParser parser = tester();
      String ex1 = "Gold";
      String ex2 = "Diamond";
     listExportersTwoProducts(parser, ex1, ex2);
    
    }
    
    
   public int numberOfExporters(CSVParser parser, String exportItem){
       
    int countResults = 0;
       
    for(CSVRecord record: parser){
         String exp = exportItem.toLowerCase();
  
         String exportCell = record.get("Exports");
         
         if(exportCell.contains(exp)){
            countResults += 1;
            
            }
    
    
    
    }
    return countResults;
}

public void testNumberOfExporters(){
    CSVParser parser = tester();
    String export = "Sugar";
    int results = numberOfExporters(parser,export);
    System.out.println(results);
}


public void bigExporters(CSVParser parser, String amount){
    
    int amountLength = amount.length();
    
for(CSVRecord record: parser){
        
  
         String valueCell = record.get("Value (dollars)");
         
         if(valueCell.length() > amountLength){
            String countryRow = record.get("Country");
            String results = countryRow + " " + valueCell;
            System.out.println(results);
            
            }
    

}
}

public void testBigExporters(){
 CSVParser parser = tester();
 String amount = "$999,999,999,999";
 bigExporters(parser, amount);

}



}


