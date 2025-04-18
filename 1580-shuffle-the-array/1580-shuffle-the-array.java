class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffle = new int[2 * n];

        for (int i = 0; i < n; i++) {
            shuffle[2 * i] = nums[i];
            shuffle[2 * i + 1] = nums[i + n];
        }

        return shuffle;
    }
}