class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        long sum = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (i <= j && sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }
}