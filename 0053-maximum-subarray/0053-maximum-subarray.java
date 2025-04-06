class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxEnding = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currentMax = maxEnding + nums[i];

            maxEnding = currentMax > nums[i] ? currentMax : nums[i];

            maxSum = maxSum > maxEnding ? maxSum : maxEnding;
        }

        return maxSum;
    }
}