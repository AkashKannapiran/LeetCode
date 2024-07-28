class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        s = s.trim();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        return length;
    }
}

/*
This solution uses java's inbuild methods
class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str[str.length-1].length();
    }
}
*/