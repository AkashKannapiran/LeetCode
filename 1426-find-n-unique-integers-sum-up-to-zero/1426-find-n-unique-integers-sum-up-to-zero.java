class Solution {
    public int[] sumZero(int n) {
        int[] zeroSum = new int[n];

        for (int i = 0; i < n; i++) {
            zeroSum[i] = i * 2 - n + 1;
        }

        return zeroSum;
    }
}