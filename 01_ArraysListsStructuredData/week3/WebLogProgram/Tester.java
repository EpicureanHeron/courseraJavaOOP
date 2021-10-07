
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
}
