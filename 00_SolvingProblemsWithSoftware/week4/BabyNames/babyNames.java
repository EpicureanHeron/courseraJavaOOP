
/**
 * Write a description of babyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class babyNames {
    
    public int totalBirths(){
        
        int maleBirthTotal = 0;
        int femaleBirthTotal = 0;
        int maleNames = 0;
        int femaleNames = 0;
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record: parser){
            
            String recordGender = record.get(1);
            
            if(recordGender.matches("M")){
                
                int recordValue = Integer.parseInt(record.get(2));
                maleBirthTotal = recordValue + maleBirthTotal;
                maleNames += 1;
            
            }
            if(recordGender.matches("F")){

                int recordValue = Integer.parseInt(record.get(2));
                femaleBirthTotal += recordValue;
                femaleNames += 1;
            
            }
            
            
        }
        System.out.println("Total Male Births: "+ maleBirthTotal);
        System.out.println("Total Female Births: "+ femaleBirthTotal);
        System.out.println("Total Male Names: "+ maleNames);
        System.out.println("Total Female Names: "+ femaleNames);
    return maleBirthTotal + femaleBirthTotal;
    }
    
    public void testTotalBirths(){
    
    int results = totalBirths();
    
    System.out.println("Total Births: "+ results);
    
    }
    
    public int getRank(int year, String name, String gender){
        
        int rank =0;
        
        FileResource fr = new FileResource("../us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record: parser){
            String rowGender = record.get(1);
            if(rowGender.matches(gender)){
                String rowName = record.get(0);
                rank += 1;
                if(rowName.matches(name)){
                    return rank;
            
            }
            
        
        }
    
    
    }
    return -1;
}


    public void testGetRank(){
    
        int results = getRank(1971, "Frank", "M");
        System.out.println("Rank of Mason in 2013 M: "+ results);
    

    }
    
    public String getName(int year, int rank, String gender){
        int currentRank = 0;
     
        FileResource fr = new FileResource("../us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record: parser){
            String rowGender = record.get(1);
            if(rowGender.matches(gender)){
                
                currentRank += 1;
                if(rank == currentRank){
                    return record.get(0);
            
            }
            
        
        }
    
    
    }
    return "NO NAME";
        
        
        
    }
    
    
    public void testgetName(){
    
        String results = getName(1982, 450 , "M");
        System.out.println("3rd ranked male name in 2013: "+ results);
    

    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        
        int rank = getRank(year,name, gender);
        
        String newName = getName(newYear, rank, gender);
        
        System.out.println("The name " + name);
        System.out.println("in the year: " + year);
        System.out.println("had the rank of : " + rank);
        System.out.println("and would be the name " + newName);
        System.out.println("in the year of our lord " +  newYear);
    
    
    }
    
    public void testwhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
    
    }
    
    public int yearOfHighestRank(String name, String gender){
    int highestRank = 999999;
    int highestRankYear = -1;
    
    DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
        
            FileResource fr = new FileResource(f);
            String fileName = f.getName();
            int year = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
            int currentRank = getRank(year, name, gender);
            
            if(currentRank < highestRank && currentRank != -1){
                highestRank = currentRank;
                highestRankYear = year;
            }
            
            
    }
    
        
    return highestRankYear;
      
}
    public void testYearOfHighestRank(){
        
        int results = yearOfHighestRank("Mich", "M");
        
        System.out.println("The highest ranked year " + results);
    
    }
    
    
    public double getAverageRank(String name, String gender){
    
       double sumOfRanks = 0.0;
       double fileCount = 0.0;
       double results = -1.0;
        
        
    DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
        
            FileResource fr = new FileResource(f);
            String fileName = f.getName();
            
            int year = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
            int currentRank = getRank(year, name, gender);
            
            if(currentRank != -1){
            
               sumOfRanks += currentRank;
            }
            
            fileCount += 1.0;
            
        }
        
        if(sumOfRanks == 0.0){
            
            return results;}
            
        return sumOfRanks/fileCount;
        
    
    }
    
        public void testGetAverageRank(){
        
        double results1 = getAverageRank("Robert", "M");
        
        System.out.println("The average of Mason M: " + results1);
    
        
        //double results2 = getAverageRank("Mason", "F");
        
        //System.out.println("The average of Mason F: " + results2);
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalBirths = 0;
        boolean passedName = false; 
        FileResource fr = new FileResource("../us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        
        
        for(CSVRecord record: parser){
            String rowGender = record.get(1);
            if(rowGender.matches(gender)){
                String rowName = record.get(0);
                if(rowName.matches(name)){
                    
                passedName = true;
                
                }
                
                if(passedName == false){
                int recordValue = Integer.parseInt(record.get(2));
                totalBirths += recordValue;
                }

                
        
        }
    
    
    }
    return totalBirths;
    }
    
    
    void testGetTotalBirthsRankedHigher(){
    
    int results = getTotalBirthsRankedHigher(1990, "Drew", "M");
    
    System.out.println("The records totalling of Ethan M: " + results);
    
    }
    
}



