class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        int oddCells = 0;

        for(int[] x : indices) {
            row[x[0]]++;
            col[x[1]]++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    oddCells++;
                }
            }
        }

        return oddCells;
    }
}