class Solution {
    public int maxFreqSum(String s) {
        int[] alphabet = new int[26];
        int MaxVowel = 0;
        int MaxConsonent = 0;

        for (char a : s.toCharArray()) {
            alphabet[a - 'a']++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            int temp = alphabet[i];
            char c = (char) (i + 'a');

            if (temp == 0) {
                continue;
            }

            if ("aeiou".contains(String.valueOf(c)) && temp >= MaxVowel) {
                MaxVowel = temp;
            } else if (!"aeiou".contains(String.valueOf(c)) && temp >= MaxConsonent) {
                MaxConsonent = temp;
            }
        }

        return MaxVowel + MaxConsonent;
    }
}