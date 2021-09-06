
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    
    public int howMany(String stringa, String stringb){
    int count = 0;
    int startIndex = 0;
    while(true){
    
    int stringStart = stringb.indexOf(stringa, startIndex);
    
    if(stringStart == -1){
        break;
    }
    count = count + 1;
    System.out.println("count:  " + count);
    startIndex = stringb.indexOf(stringa, startIndex) + stringa.length();
    
    }
    
    
    
    return count;
    }
   
 public void testHowMany(){
    String stringa = "GAA";
    System.out.println("string a is : " + stringa);
    String stringb = "ATGAACGAATTGAATC";
    System.out.println("string b is : " + stringb);
    int results = howMany(stringa, stringb);
    System.out.println("string a appears in string b this many times: " + results);
    
    stringa = "A";
    System.out.println("string a is : " + stringa);
    stringb = "Aunty Annie's Aligators";
    System.out.println("string b is : " + stringb);
    results = howMany(stringa, stringb);
    System.out.println("string a appears in string b this many times: " + results);
    
    stringa = "abc";
    System.out.println("string a is : " + stringa);
    stringb = "abcdefgabcababc123abcfdlkaj;df";
    System.out.println("string b is : " + stringb);
    results = howMany(stringa, stringb);
    System.out.println("string a appears in string b this many times: " + results);
    }

}
