class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int totalDistinctCount = (int) Arrays.stream(nums).distinct().count();
        int left = 0;
        int completeSubArrayCount = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);

            while (frequencyMap.size() == totalDistinctCount) {
                completeSubArrayCount +=nums.length - right;
                int leftElement = nums[left];
                frequencyMap.put(leftElement, frequencyMap.get(leftElement) - 1);

                if (frequencyMap.get(leftElement) == 0) {
                    frequencyMap.remove(leftElement);
                }

                left++;
            }
        }

        return completeSubArrayCount;
    }
}