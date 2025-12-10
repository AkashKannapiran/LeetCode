class Solution {

    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        int answer = 1;
        int mod = 1000000007;

        for (int i = 2; i < n; i++) {
            answer = (int) (((long) answer * i) % mod);
        }

        return answer;
    }
}