public class Solution {

    public int maxDistance(String s, int k) {
        int latitude = 0, longitude = 0, ans = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            switch (c) {
                case 'N' -> latitude++;
                case 'S' -> latitude--;
                case 'E' -> longitude++;
                case 'W' -> longitude--;
            }
            
            ans = Math.max(ans,
                    Math.min(
                        Math.abs(latitude) + Math.abs(longitude) + k * 2,
                        i + 1
                    )
            );
        }

        return ans;
    }
}