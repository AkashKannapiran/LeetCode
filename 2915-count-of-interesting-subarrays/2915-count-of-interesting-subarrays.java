class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long interestingSubArrayCount = 0;
        long matchedConditionCount = 0;
        Map<Integer, Long> remainderCountMap = new HashMap<>();
        remainderCountMap.put(0, 1L);

        for (int num : nums) {
            if (num % modulo == k) {
                matchedConditionCount++;
            }

            int currentRemainder = (int) (matchedConditionCount % modulo);
            int requiredRemainder = (currentRemainder - k + modulo) % modulo;

            interestingSubArrayCount += remainderCountMap.getOrDefault(requiredRemainder, 0L);

            remainderCountMap.put(currentRemainder, remainderCountMap.getOrDefault(currentRemainder, 0L) + 1);
        }

        return interestingSubArrayCount;
    }
}