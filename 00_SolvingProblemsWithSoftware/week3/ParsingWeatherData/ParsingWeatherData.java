
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ParsingWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser){
    
    CSVRecord coldestRow = null;
        
    for(CSVRecord record: parser){
        coldestRow = lowestRecord(record, coldestRow, "TemperatureF");
        }
        
    return coldestRow;
    
    }
    
    public CSVRecord lowestRecord(CSVRecord current, CSVRecord lowest, String value){
        if(lowest == null){
            return current;
        }
        String currentStringValue = current.get(value);
        
        if(currentStringValue == "N/A"){
            return lowest;
        }
       
        double currentValue = Double.parseDouble(currentStringValue);
        double currentLowestValue = Double.parseDouble(lowest.get(value));
        if(currentValue < currentLowestValue){
            
            return current;
            
        }
        else{
        return lowest;
        }
    }
    
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord results = coldestHourInFile(parser);
        System.out.println(results.get("TemperatureF"));
        System.out.println(results.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature(){
        CSVRecord lowestSoFar = null;
        String lowestFile = "";
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            if(lowestFile == ""){
                lowestFile = f.getName();
            }
            CSVRecord fileLowest = coldestHourInFile(fr.getCSVParser());
            
            lowestSoFar = lowestRecord(fileLowest, lowestSoFar, "TemperatureF");
            // if the lowest directory and lowest file match, then the file is the lowest
            //if(directoryLowest.get("TemparatureF" < fileLowest){
             //   lowestFile = f.getName();
              //  System.out.println(lowestFile);
           // }
            
        
        }
        String results = lowestSoFar.get("DateUTC");
        return results;
    }
    
    public void testFileWithColdestTemperature(){
        String lowestFile = fileWithColdestTemperature();
        
        System.out.println(lowestFile);
    
    
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
    CSVRecord lowestHumidtyRow = null;
        
    for(CSVRecord record: parser){
        lowestHumidtyRow = lowestRecord(record, lowestHumidtyRow , "Humidity");
        }
        
    return lowestHumidtyRow;

    
    }
    
        public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord results = lowestHumidityInFile(parser);
        System.out.println(results.get("Humidity"));
        System.out.println(results.get("DateUTC"));
    }
    
        public String fileWithLowestHumidity(){
        CSVRecord lowestSoFar = null;
        String lowestFile = "";
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            if(lowestFile == ""){
                lowestFile = f.getName();
            }
            CSVRecord fileLowest = lowestHumidityInFile(fr.getCSVParser());
            
            lowestSoFar = lowestRecord(fileLowest, lowestSoFar, "Humidity");
            // if the lowest directory and lowest file match, then the file is the lowest
          
            
        
        }
        String results = lowestSoFar.get("DateUTC");
        
        return results;
    }
    
       public void testFileWithLowestHumidity(){
        String lowestFile = fileWithLowestHumidity();
        
        System.out.println(lowestFile);
    
    
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double sumOfTemps = 0.0;
        double records = 0.0;
        for(CSVRecord record: parser){
            
            String currentTempString = record.get("TemperatureF");
            double currentTemp = Double.parseDouble(currentTempString);
            sumOfTemps += currentTemp;
            records += 1;
    
    }
        return sumOfTemps/records;
    }
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double results = averageTemperatureInFile(parser);
        System.out.println("Average Temp in file: " + results);
        
    
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
    
    double sumOfTemps = 0.0;
        double records = 0.0;
        for(CSVRecord record: parser){
            
            String currentHumidityString = record.get("Humidity");
            double currentHumidity = Double.parseDouble(currentHumidityString);
            
            if(currentHumidity >= value){
                
                String currentTempString = record.get("TemperatureF");
                double currentTemp = Double.parseDouble(currentTempString);
                sumOfTemps += currentTemp;
                records += 1;
            }
            
    
    }
    if(records == 0.0){
        return 0.0;
    }
    else{
    return sumOfTemps/records;
}
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
    FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
    double results = averageTemperatureWithHighHumidityInFile(parser, 80);
     System.out.println("Average Temp High Humidity in file: " + results);
    }
}
