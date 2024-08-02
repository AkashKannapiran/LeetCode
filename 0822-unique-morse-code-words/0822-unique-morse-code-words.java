class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", 
                                "..-.", "--.", "....", "..", ".---", 
                                "-.-", ".-..", "--", "-.", "---", 
                                ".--.", "--.-", ".-.", "...", "-", 
                                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder code = new StringBuilder();

            for (int j = 0; j < words[i].length(); j++) {
                code.append(morseCode[words[i].charAt(j) - 'a']);
            }

            set.add(code.toString());
        }

        return set.size();
    }
}