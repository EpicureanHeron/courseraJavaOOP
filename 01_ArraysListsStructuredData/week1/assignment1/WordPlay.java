
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
/* Write a method isVowel that has one Char parameter named ch. This method returns true 
if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. 
You should write a tester method to see if this method works correctly. For example, 
isVowel(‘F’) should return false, and isVowel(‘a’) should return true.  */
    public boolean isVowel(char ch){
        
        String vowelString = "aeiou";
        
        char lowerCh = Character.toLowerCase(ch);
        
        int indexCh = vowelString.indexOf(lowerCh);
        
        if(indexCh != -1){
        
        return true;
        }
        else{
        
        return false;
        }
       
    
    }
    public void testIsVowel(){
    
    boolean test1 = isVowel('F');
    
    System.out.println( "result for test of 'F': " + test1 );  
    
    boolean test2 = isVowel('e');
    
    System.out.println( "result for test of 'e': " + test2 );  
    
    boolean test3 = isVowel('I');
    System.out.println( "result for test of 'I': " + test3 );  

    }
/*
 * Write a method replaceVowels that has two parameters, a String named phrase and a 
 * Char named ch. This method should return a String that is the string phrase with all
 * the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) 
 * returns the string “H*ll* W*rld”. Be sure to call the method isVowel that you wrote and also test this method.
 */   


public String replaceVowels(String phrase, char ch){
    
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < phrase.length(); i++) {

                char phraseChar = phrase.charAt(i);
                
                if(isVowel(phraseChar)){
                    sb.insert(i, ch);
                }
                else{
                    sb.insert(i, phraseChar);
             
                }
        
    }
    System.out.println(sb);
    return sb.toString();
}

 public void testReplaceVowels(){
     String test = replaceVowels("Howdy Duty Boy-o!", 'J');
     
     String test2 = replaceVowels("You're part of chain of command that stretches all the way back to London!", 'v');
    }

/*
 *     Write a method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String 
 *     that is the string phrase but with the Char ch (upper- or lowercase) replaced by

     ‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or

     ‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
     
     
 */

public String emphasize(String phrase, char ch){

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < phrase.length(); i++) {

                char phraseChar = phrase.charAt(i);
                
                if(phraseChar == ch && i%2 == 0){
                    sb.insert(i, '+');
                }
                else if(phraseChar == ch  && i%2 != 0) {
                
                    sb.insert(i, '*');
                }
                else{
                    sb.insert(i, phraseChar);
             
                }
        
    }
    System.out.println(sb);
    return sb.toString();


}

public void testemphasize(){

    String test1 =  emphasize("Mary Bella Abracadabra", 'a') ;
    String test2 = emphasize("dna ctgaaactga", 'a');

}
}
