
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
    /*
     * In the LogAnalyzer class, write the method iPsWithMostVisitsOnDay, 
     * which has two parameters—the first one is a HashMap<String, 
     * ArrayList<String>> that uses records and maps days from web logs to 
     * an ArrayList of IP addresses that occurred on that day,
     * and the second parameter is a String representing a day in the format “MMM DD” 
     * described above. This method returns an ArrayList<String> 
     * of IP addresses that had the most accesses on the given day. For example, if you 
     * use the file weblog3-short_log, and the parameter
     * for the day is “Sep 30”, then there are two IP addresses in the ArrayList 
     * returned: 61.15.121.171 and 177.4.40.87. 
     * Hint: This method should call another method you have written.
     */
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dayMap, String date){
        ArrayList<String> ipArray= dayMap.get(date);
        HashMap<String, Integer> ipCounts= new HashMap<String,Integer>();
        ArrayList<String> maxIPArray = new ArrayList<String>();
        
         for (String ip : ipArray) {
              
             if(!ipCounts.containsKey(ip)){
                  
                 
                  ipCounts.put(ip, 1);
             }
             else{
                ipCounts.put(ip, ipCounts.get(ip) + 1);
                }
        
        
        }
        
        int maxValue = mostNumberVisitsByIP(ipCounts);
        
        for(String w: ipCounts.keySet()){
            if(ipCounts.get(w) == maxValue){
                maxIPArray.add(w);
            
            }
            
        }
        return maxIPArray;
    
    }
}