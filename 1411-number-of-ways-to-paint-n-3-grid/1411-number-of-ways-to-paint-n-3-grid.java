class Solution {

    private static final int MOD = 1000000007;

    public int numOfWays(int n) {
        if (n == 0) {
            return 0;
        }

        List<int[]> states = new ArrayList<>();
        states.add(new int[] { 1, 2, 1 });
        states.add(new int[] { 1, 2, 3 });
        states.add(new int[] { 1, 3, 1 });
        states.add(new int[] { 1, 3, 2 });
        states.add(new int[] { 2, 1, 2 });
        states.add(new int[] { 2, 1, 3 });
        states.add(new int[] { 2, 3, 1 });
        states.add(new int[] { 2, 3, 2 });
        states.add(new int[] { 3, 1, 2 });
        states.add(new int[] { 3, 1, 3 });
        states.add(new int[] { 3, 2, 1 });
        states.add(new int[] { 3, 2, 3 });

        int numStates = states.size();
        int[][] compatible = new int[numStates][numStates];

        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < numStates; j++) {
                int[] prev = states.get(i);
                int[] next = states.get(j);

                if (prev[0] != next[0] && prev[1] != next[1] && prev[2] != next[2]) {
                    compatible[i][j] = 1;
                }
            }
        }

        long[] dp = new long[numStates];

        for (int i = 0; i < numStates; i++) {
            dp[i] = 1;
        }

        if (n == 1) {
            long total = 0;

            for (long val : dp) {
                total = (total + val) % MOD;
            }

            return (int) total;
        }

        for (int row = 2; row <= n; row++) {
            long[] nextDp = new long[numStates];

            for (int current = 0; current < numStates; current++) {
                for (int prev = 0; prev < numStates; prev++) {
                    if (compatible[prev][current] == 1) {
                        nextDp[current] = (nextDp[current] + dp[prev]) % MOD;
                    }
                }
            }

            dp = nextDp;
        }

        long total = 0;

        for (long val : dp) {
            total = (total + val) % MOD;
        }

        return (int) total;
    }
}