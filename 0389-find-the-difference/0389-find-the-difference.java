class Solution {
    public char findTheDifference(String s, String t) {
        String combined = s + t;
        char[] combinedArray = combined.toCharArray();
        char extra = 0;

        for (char ca : combinedArray) {
            extra ^= ca;
        }

        return extra;
    }
}