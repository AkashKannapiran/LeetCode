class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = (high - low) / 2 + low;

            mergeSort(nums, low, middle);
            mergeSort(nums, middle + 1, high);
            mergeFun(nums, low, middle, high);
        }
    }

    public static void mergeFun(int[] nums, int l, int m, int r) {
        int n1 = m + 1 - l;
        int n2 = r - m;
        int[] left = new int[n1];

        for (int i = 0; i < n1; i++) {
            left[i] = nums[l + i];
        }

        int[] right = new int[n2];

        for (int i = 0; i < n2; i++) {
            right[i] = nums[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 || j < n2) {
            if (j == n2 || i < n1 && left[i] < right[j]) {
                nums[k++] = left[i++];
            }
            else {
                nums[k++] = right[j++];
            }
        }
    }
}