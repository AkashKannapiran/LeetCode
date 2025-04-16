class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int same = 0;
        int right = -1;
        HashMap<Integer, Integer> count = new HashMap<>();
        long ans = 0;

        for (int left = 0; left < n; ++left) {
            while (same < k && right + 1 < n) {
                ++right;
                same += count.getOrDefault(nums[right], 0);
                count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            }

            if (same >= k) {
                ans += n - right;
            }

            count.put(nums[left], count.get(nums[left]) - 1);
            same -= count.get(nums[left]);
        }

        return ans;
    }
}