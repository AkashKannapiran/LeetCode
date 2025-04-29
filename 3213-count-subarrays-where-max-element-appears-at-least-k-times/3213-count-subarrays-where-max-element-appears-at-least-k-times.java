class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        int left = 0;
        long maxOccurence = 0;
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                maxOccurence++;
            }

            while (maxOccurence >= k) {
                if (nums[left] == max) {
                    maxOccurence--;
                }
                
                left++;
            }

            result += left;
        }

        return result;
    }
}