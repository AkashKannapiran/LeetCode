/*class Solution {
    public char findTheDifference(String s, String t) {
        return (char) (s + t).chars().reduce(0, (c, d) -> c ^ d);
    
    }
}*/

public class Solution {
    public char findTheDifference(String s, String t) {
        char result = t.charAt(s.length()); 
        
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        
        return result;
    }
}