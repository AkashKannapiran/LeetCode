class Solution {
    public int longestBalanced(int[] nums) {

        int max = 0;

        for (int x : nums)
            max = Math.max(max, x);

        int[] last = new int[max + 1];

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            if (maxLen >= n - i)
                break;

            int balance = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];
                
                if (last[x] != i + 1) {
                    last[x] = i + 1;
                    balance += 1 - (x & 1) * 2;
                }
                
                if (balance == 0)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}
