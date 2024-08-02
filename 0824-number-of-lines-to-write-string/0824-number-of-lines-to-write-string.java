class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        result[0] = 1;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            if (length + widths[s.charAt(i) - 'a'] <= 100) {
                length += widths[s.charAt(i) - 'a'];
            } else {
                result[0]++;
                length = widths[s.charAt(i) - 'a'];
            }
        }
        result[1] = length;

        return result;
    }
}