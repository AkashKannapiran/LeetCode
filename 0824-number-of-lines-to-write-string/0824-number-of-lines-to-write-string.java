class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int width = 0;

        for (char ch : s.toCharArray()) {
            int charWidth = widths[ch - 'a'];

            if (charWidth + width > 100) {
                line++;
                width = 0;
            }

            width += charWidth;
        }

        return new int[] {line, width};
    }
}