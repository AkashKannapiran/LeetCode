class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long totalFixedBoundSubarrays = 0;
        int lastInvalidIndex = -1;
        int lastMinKIndex = -1;
        int lastMaxKIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            if (currentNum < minK || currentNum > maxK) {
                lastInvalidIndex = i;
            }

            if (currentNum == minK) {
                lastMinKIndex = i;
            }

            if (currentNum == maxK) {
                lastMaxKIndex = i;
            }

            int validStartIndex = Math.min(lastMinKIndex, lastMaxKIndex);

            if (validStartIndex > lastInvalidIndex) {
                totalFixedBoundSubarrays += (validStartIndex -lastInvalidIndex);
            }
        }

        return totalFixedBoundSubarrays;
    }
}