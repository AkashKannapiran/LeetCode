class Solution {

    int fn1(String s, char x, char y) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n;) {
            while (i < n && s.charAt(i) != x && s.charAt(i) != y)
                i++;

            int j = i, p = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, i - 1);

            while (j < n && (s.charAt(j) == x || s.charAt(j) == y)) {
                p += (s.charAt(j) == x ? 1 : -1);

                if (mp.containsKey(p)) {
                    res = Math.max(res, j - mp.get(p));
                } else {
                    mp.put(p, j);
                }

                j++;
            }

            i = j;
        }

        return res;
    }

    int fn2(String s) {
        int n = s.length(), res = 0;

        for (int i = 0; i < n;) {
            int j = i, ca = 0, cb = 0, cc = 0;

            HashMap<String, Integer> mp = new HashMap<>();
            mp.put("0#0", i - 1);

            while (j < n) {
                char ch = s.charAt(j);

                if (ch == 'a')
                    ca++;
                else if (ch == 'b')
                    cb++;
                else if (ch == 'c')
                    cc++;
                else
                    break;

                int d1 = ca - cb;
                int d2 = ca - cc;
                String key = d1 + "#" + d2;

                if (mp.containsKey(key)) {
                    res = Math.max(res, j - mp.get(key));
                } else {
                    mp.put(key, j);
                }
                
                j++;
            }

            i = j;
        }

        return res;
    }

    int fn3(String s, char x) {
        int n = s.length(), res = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == x)
                curr++;
            else
                curr = 0;

            res = Math.max(res, curr);
        }
        
        return res;
    }

    public int longestBalanced(String s) {
        return Math.max(
                Math.max(
                        Math.max(fn1(s, 'a', 'b'), fn1(s, 'b', 'c')),
                        Math.max(fn1(s, 'a', 'c'), fn2(s))),
                Math.max(fn3(s, 'a'), Math.max(fn3(s, 'b'), fn3(s, 'c'))));
    }
}
