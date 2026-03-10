class Solution {

    private static final int MOD = 1_000_000_007;

    private int add(int a, int b) {
        return (a + b) % MOD;
    }

    private int subtract(int a, int b) {
        return (a - b + MOD) % MOD;
    }

    private int multiply(int a, int b) {
        return (int) ((long) a * b % MOD);
    }

    public int numberOfStableArrays(int zero, int one, int limit) {

        int m = Math.max(zero, one);

        int[][] sumLimit = new int[m + 1][m + 1];

        int[] prefix = new int[m + 1];
        int[] prev = sumLimit[0];

        prev[0] = 1;

        for (int count = 1; count <= m; count++) {

            int maxSum = Math.min(count * limit, m);
            int running = 0;

            for (int i = 0; i <= maxSum; i++) {
                prefix[i] = running;
                running = add(running, prev[i]);
            }

            int[] curr = sumLimit[count];

            for (int i = count; i <= maxSum; i++) {
                if (i < limit) {
                    curr[i] = prefix[i];
                } else {
                    curr[i] = subtract(prefix[i], prefix[i - limit]);
                }
            }

            prev = curr;
        }

        int result = (m <= limit) ? 2 : 0;

        int c0 = sumLimit[1][zero];
        int c1 = sumLimit[1][one];

        for (int i = 2; i <= m; i++) {

            int prevC0 = c0;
            int prevC1 = c1;

            c0 = sumLimit[i][zero];
            c1 = sumLimit[i][one];

            result = add(result, multiply(c0, prevC1));
            result = add(result, multiply(c1, prevC0));

            int t = multiply(c0, c1);
            result = add(result, add(t, t));
        }

        return result;
    }
}