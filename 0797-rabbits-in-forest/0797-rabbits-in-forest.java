class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int total = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            total += Math.ceil((double)entry.getValue() / (entry.getKey() + 1)) * (entry.getKey() + 1);
        }

        return total;
    }
}