class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] gridToArray = new int[grid.length * grid[0].length];
        int mod = grid[0][0] % x;
        int index = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[i].length; j++) {
                if (grid[i][j] % x != mod) {
                    return -1;
                }
                gridToArray[index++] = grid[i][j];
            }
        }

        Arrays.sort(gridToArray);
        int median = gridToArray[gridToArray.length / 2];
        int steps  = 0;

        for (int i = 0; i < gridToArray.length; i++) {
            steps += Math.abs(gridToArray[i] - median) / x;
        }

        return steps;
    }
}