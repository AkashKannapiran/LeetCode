class Solution {
    final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        return (int)((binaryExponentiation(4, n / 2) * binaryExponentiation(5, n - n / 2)) % MOD);
    }

    private long binaryExponentiation(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}