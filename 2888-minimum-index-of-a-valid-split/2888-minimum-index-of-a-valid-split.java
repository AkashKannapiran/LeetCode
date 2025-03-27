class Solution {
    public int minimumIndex(List<Integer> nums) {
        int majorityElement = mooresVotingAlgo(nums);
        int maxFreq = 0;

        for (int num : nums) {
            if (num == majorityElement) {
                maxFreq++;
            }
        }

        int leftCount = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == majorityElement) {
                leftCount++;
                maxFreq--;
            }

            if ((leftCount > (i + 1) / 2) && (maxFreq > (nums.size() - i - 1) / 2)) {
                return i;
            }
        }

        return -1;
    }

    private int mooresVotingAlgo(List<Integer> nums) {
        int majority = nums.get(0);
        int count = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = nums.get(i);
                count = 1;
            }
        }
        
        return majority;
    }
}