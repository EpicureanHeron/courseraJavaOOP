
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
    
    public HashMap<String, Integer> countVisitsPerIP(){
           HashMap<String, Integer> ipMap = new HashMap<String,Integer>();
           
           for(LogEntry le: records){
               String ip = le.getIpAddress();
               if(!ipMap.containsKey(ip)){
                   ipMap.put(ip, 1);
                
                }
               else{
                   ipMap.put(ip, ipMap.get(ip) +1);
                }
            
            }
           return ipMap;
    
    }
        
    public int mostNumberVisitsByIP(HashMap<String, Integer> ipMap){
         int maxValue= 0;
         for(String w : ipMap.keySet()){
             if(ipMap.get(w) > maxValue){
                maxValue =ipMap.get(w);
                
                }
        
    }
        return maxValue;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> ipMap){
        ArrayList<String> mostIPs = new ArrayList<String>();
        int maxValue = mostNumberVisitsByIP(ipMap);
        
        for(String w: ipMap.keySet()){
            if(ipMap.get(w) == maxValue){
                mostIPs.add(w);
            }
        
        }
        return mostIPs;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> dayMap = new HashMap<String,ArrayList<String>>();
        for(LogEntry le: records){
            String lineDate = le.getAccessTime().toString().substring(4, 10);
            
             if(!dayMap.containsKey(lineDate)){
                  ArrayList<String> ips = new ArrayList<String>();
                  ips.add(le.getIpAddress());
                  dayMap.put(lineDate, ips);
             }
             else{
                dayMap.get(lineDate).add(le.getIpAddress());
                }
}
        return dayMap;
}

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> dayMap){
        int maxSize = 0;
        String maxDate = "";
        
        for(String w: dayMap.keySet()){
            if(dayMap.get(w).size() > maxSize){
                maxSize = dayMap.get(w).size();
                maxDate = w;
            
            }
            
        }
        return maxDate;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dayMap, String date){
        ArrayList<String> ipArray= dayMap.get(date);
        
        return ipArray;
    
    }
}