class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = Integer.MIN_VALUE;

        for (int[] account : accounts) {
            int sum = 0;

            for (int amount : account) {
                sum += amount;
            }

            wealth = (sum > wealth) ? sum : wealth;
        }

        return wealth;
    }
}