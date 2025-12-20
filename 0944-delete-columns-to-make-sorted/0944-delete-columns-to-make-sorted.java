class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            result += isUnsorted(strs, i);
        }

        return result;
    }

    public int isUnsorted(String[] strs, int x) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(x) < strs[i - 1].charAt(x)) {
                return 1;
            }
        }

        return 0;
    }
}