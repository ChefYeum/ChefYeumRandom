import java.util.HashMap;
import java.util.Arrays;

public class ArrStr{
    public static boolean isUniqueQuad(String word){
        for (int i = 0; i < word.length(); i++){
            for (int j = 0; j < word.length(); j++){
                if (word.charAt(i) == word.charAt(j) && i != j) return false;
            }
        }
        //otherwise
        return true;
    }
    public static boolean isPermSort(String word, String target){
        if (word.length() != target.length()) return false;
        else {
            char[] wordChar = word.toCharArray();    
            Arrays.sort(wordChar);
            char[] targChar = target.toCharArray();
            Arrays.sort(targChar);
            for (int i = 0; i < word.length(); i++){
                if (wordChar[i] != targChar[i]) return false;
            }
            return true;
        }
    }
    public static boolean isPermCount(String word, String target){
        if (word.length() != target.length()) return false;

        HashMap<Character,Integer> wordCount = new HashMap<>();
        HashMap<Character,Integer> targCount = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            char wordChar = word.charAt(i);
            char targChar = target.charAt(i);
            wordCount.put(wordChar,wordCount.getOrDefault(wordChar,0)+1);
            targCount.put(targChar,targCount.getOrDefault(targChar,0)+1);
        } 
        

        for (char c : wordCount.keySet()){
            if (wordCount.get(c) != targCount.get(c)) return false;
        }

        //Otherwise
        return true;
    }
    

    //1.5
    public static boolean isOneAway(String w1, String w2){

        int minLen = Math.min(w1.length(), w2.length());

        int midStart = 0;
        for (int i = 0; i < minLen; i++){
            if (w1.charAt(i) != w2.charAt(i)){ break; }
        }
        
        int midEnd = minLen-1;
        for (int i = midEnd; i > 0; i--){
            if (w1.charAt(i) != w2.charAt(i)){ break; }
        }

        int diffLen = midEnd - midStart;

        return diffLen > 1;


    }

// Main function for testing
    public static void main(String[] args){
        String str1 = args[0];
        String str2 = args[1];
        boolean result = isPermCount(str1,str2);
        System.out.println(result);
        result = isPermSort(str1, str2);
        System.out.println(result);
         
    }
} 
