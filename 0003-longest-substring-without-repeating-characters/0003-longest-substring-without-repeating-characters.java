class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[256];

            for (int j = i; j < n; j++) {
                if (vis[s.charAt(j)]) {
                    break;
                } else {
                    maxLen = Math.max(maxLen, j - i + 1);
                    vis[s.charAt(j)] = true;
                }
            }

            if (maxLen >= n - i) break;
        }

        return maxLen;
    }
}