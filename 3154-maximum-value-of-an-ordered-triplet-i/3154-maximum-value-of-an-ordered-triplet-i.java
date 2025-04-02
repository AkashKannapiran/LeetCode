class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTriplet = 0;
        long maxLeft = 0;
        long maxDiff = 0;

        for(int i = 0; i < n; ++i) {
            maxTriplet = Math.max(maxTriplet, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxLeft - nums[i]);
            maxLeft = Math.max(maxLeft, nums[i]);
        }

        return maxTriplet;
    }
}

/*
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int triplet = (nums[i] - nums[j]) * nums[k];
                    max = (max > triplet) ? max : triplet;
                }
            }
        }
        
        return max;
    }
}
*/