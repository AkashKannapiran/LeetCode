class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        
        ans[0] = cost[0];
        int minCost = ans[0];
        
        for (int i = 1; i < n; i++) {
            minCost = (minCost < cost[i]) ? minCost : cost[i];
            ans[i] = minCost;
        }
        
        return ans;
    }
}