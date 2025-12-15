class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int count = 1;
        long total = 1;

        for (int i = 1; i < n; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                count = 1;
            }

            total += count;
        }

        return total;
    }
}