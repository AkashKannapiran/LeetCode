class Solution {
    public int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];
        int count = 0;
        int middle = 0;

        for (String word : words) {
            int x = word.charAt(0) - 'a';
            int y = word.charAt(1) - 'a';

            if (freq[y][x] > 0) {
                freq[y][x]--;
                count += 4;

                if (x == y) {
                    middle--;
                }
            } else {
                freq[x][y]++;

                if (x == y) {
                    middle++;
                }
            }
        }

        if (middle > 0) {
            count += 2;
        }

        return count;
    }
}

/*

Using HashMap + Greedy O(n*L)

Map<String, Integer> freq = new HashMap<>();
        int count = 0;
        int alreadyPalindrome = 0;

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            int wordFreq = entry.getValue();
            String revString = new StringBuilder(word).reverse().toString();

            if (word.equals(revString)) {
                count += (wordFreq / 2) * 4;

                if (wordFreq % 2 == 1) {
                    alreadyPalindrome = 1;
                }
            } else if (word.compareTo(revString) < 0 && freq.containsKey(revString)) {
                count += Math.min(wordFreq, freq.get(revString)) * 4;
            }
        }

        return count + alreadyPalindrome * 2;

*/