class Solution {
    public int differenceOfSums(int n, int m) {
        int numOne = 0;
        int numTwo = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                numOne += i;
            }

            if (i % m == 0) {
                numTwo += i;
            }
        }

        return numOne - numTwo;
    }
}