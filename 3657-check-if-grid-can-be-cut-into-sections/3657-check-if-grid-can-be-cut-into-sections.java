class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> mergedX = buildAndMerge(rectangles, true);

        if (mergedX.size() >= 3) {
            return true;
        }

        List<int[]> mergedY = buildAndMerge(rectangles, false);

        if (mergedY.size() >= 3) {
            return true;
        }

        return false;
    }

    private List<int[]> buildAndMerge(int[][] rectangles, boolean vertical) {
        List<int[]> intervals = new ArrayList<>();

        for (int[] rectangle : rectangles) {
            intervals.add(vertical ? new int[]{rectangle[0], rectangle[2]} : new int[]{rectangle[1], rectangle[3]});
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] next = intervals.get(i);

            if (current[1] > next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);
        return merged;
    }
}