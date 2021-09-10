
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class ParsingWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser){
    
   
    CSVRecord coldestRow = null;
        
    for(CSVRecord record: parser){
        if(coldestRow == null){
            coldestRow = record;
        }
        String stringTemp = record.get("TemperatureF");
       
        double newRowTemp = Double.parseDouble(stringTemp);
        double currentColdestTemp = Double.parseDouble(coldestRow.get("TemperatureF"));
        if(newRowTemp < currentColdestTemp){
            
            coldestRow = record;
            
        }
        
    
    }
    
    return coldestRow;
    
    }
    
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord results = coldestHourInFile(parser);
        System.out.println(results.get("TemperatureF"));
        System.out.println(results.get("TimeEST"));
    }
}
