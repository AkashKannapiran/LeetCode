class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTriplet = 0;
        long maxDiff = 0;
        long maxLeft = 0;

        for (int i = 0; i < n; ++i) {
            maxTriplet = Math.max(maxTriplet, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxLeft - nums[i]);
            maxLeft = Math.max(maxLeft, nums[i]);
        }

        return maxTriplet;
    }
}