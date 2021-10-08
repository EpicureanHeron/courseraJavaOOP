
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAll();
        
        
        
    }
    public void testUniqueIP(){
    LogAnalyzer la = new LogAnalyzer();
    la.readFile("short-test_log");
    int uniqueIPCount = la.countUniqueIPs();
    System.out.println("file has total unique IPs: " + uniqueIPCount);
    
    }
    
    public void testprintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();

        la.readFile("weblog1_log");
        
        ArrayList<String> uniqueIPsOnDay = la.uniqueIPVisitsOnDay("Mar 17");
        
        System.out.println("This file has: " + uniqueIPsOnDay.size() + " of unique IPs on the day");
        
    }
    
    public void testcountUniqueIPsinRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        int total = la.countUniqueIPsinRange(200, 299);
        System.out.println("file has total unique IPs: " + total);
    
    
    }
    
    public void testCountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, Integer> ipMap = la.countVisitsPerIP();
        
         for(String w : ipMap.keySet()){
             System.out.println(w + " has a total of " + ipMap.get(w));
        
    }

}

    public void testMostNumberVisitsByIP(){
         LogAnalyzer la = new LogAnalyzer();
         la.readFile("weblog3-short_log");
         HashMap<String, Integer> ipMap = la.countVisitsPerIP();
         int max = la.mostNumberVisitsByIP(ipMap);
         
          System.out.println("Max number of visits: " + max);
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, Integer> ipMap = la.countVisitsPerIP();
        ArrayList<String> ipList= la.iPsMostVisits(ipMap);
        for(String w: ipList){
            System.out.println(w);
        }
    }
    
    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> dayMap = la.iPsForDays();
        for(String w: dayMap.keySet()){
            System.out.println(w + " has a total of " + dayMap.get(w).size());
        }
    }
    
    public void testDayWithMostIPVisits(){
     LogAnalyzer la = new LogAnalyzer();
     la.readFile("weblog3-short_log");
     HashMap<String, ArrayList<String>> dayMap = la.iPsForDays();
     String maxDate = la.dayWithMostIPVisits(dayMap);
     System.out.println("Day with most I visists is " + maxDate);
    
    }
}
