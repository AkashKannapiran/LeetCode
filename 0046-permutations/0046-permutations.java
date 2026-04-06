class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        solve(nums, result, new ArrayList<>(), visited, n);

        return result;
    }

    private void solve(int[] nums, List<List<Integer>> result, ArrayList<Integer> DS, boolean[] visited, int n) {

        if (DS.size() == n) {
            result.add(new ArrayList<>(DS));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DS.add(nums[i]);
                visited[i] = true;

                solve(nums, result, DS, visited, n);

                visited[i] = false;
                DS.remove(DS.size() - 1);
            }
        }
    }
}