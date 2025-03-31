class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int commonDiff = arr[0] - arr[1];

        for (int i = 2; i < arr.length; i++) {
            if (commonDiff != arr[i - 1] - arr[i]) {
                return false;
            }
        }

        return true;
    }
}