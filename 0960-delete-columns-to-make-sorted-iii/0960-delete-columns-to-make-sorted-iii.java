class Solution {
    public int minDeletionSize(String[] strs) {
        int w = strs[0].length();
        int[] dp = new int[w];
        Arrays.fill(dp, 1);

        for (int i = w - 2; i >= 0; --i) {
            search: for (int j = i + 1; j < w; ++j) {
                for (String str : strs) {
                    if (str.charAt(i) > str.charAt(j)) {
                        continue search;
                    }
                }

                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        int kept = 0;

        for (int x : dp) {
            kept = Math.max(kept, x);
        }

        return w - kept;

    }
}