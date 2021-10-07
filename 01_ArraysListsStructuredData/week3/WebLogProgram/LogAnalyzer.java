
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         records.clear();
         
         FileResource resource = new FileResource(filename);
         for(String line : resource.lines()){
             LogEntry lineLog = WebLogParser.parseEntry(line);
             
             records.add(lineLog);
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le: records){
            String ip = le.getIpAddress();
                if(!uniqueIPs.contains(ip)){
                    uniqueIPs.add(ip);
                }
            
            }
        return uniqueIPs.size();
        }
        
     public void printAllHigherThanNum(int num){
        ArrayList<String> numberArray = new ArrayList<String>();
         for(LogEntry le: records){
            int code = le.getStatusCode();
                if(code > num){
                    System.out.println(le);
                }
            
            }

        
        
        }
        
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIpsOnDay  = new ArrayList<String>();
        for(LogEntry le: records){
            String lineDate = le.getAccessTime().toString().substring(4, 10);
           
            if(someday.equals(lineDate)){
                String ip = le.getIpAddress();
                 if(!uniqueIpsOnDay.contains(ip)){
                    uniqueIpsOnDay.add(ip);
                }
            
            }
        }
        
        return uniqueIpsOnDay;
    }
    
    public int countUniqueIPsinRange(int low, int high){
        ArrayList<String> ipArray = new ArrayList<String>();
        
        for(LogEntry le: records){
            int code = le.getStatusCode();
                if(low <= code && high >= code){
                   String ip = le.getIpAddress();
                 if(!ipArray.contains(ip)){
                    ipArray.add(ip);
                }
                }
            
            }
        return ipArray.size();
    }
}
