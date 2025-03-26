class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[n - 1 - i][i];
        }

        return (n % 2 == 0) ? sum : sum - mat[n / 2][n / 2];
    }
}