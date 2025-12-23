class Solution {

    public int maxTwoEvents(int[][] events) {
        List<int[]> times = new ArrayList<>();

        for (int[] event : events) {
            times.add(new int[] { event[0], 1, event[2] });
            times.add(new int[] { event[1] + 1, 0, event[2] });
        }

        times.sort((a, b) -> a[0] == b[0]
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));

        int ans = 0;
        int maxValue = 0;

        for (int[] timeValue : times) {
            if (timeValue[1] == 1) {
                ans = Math.max(ans, timeValue[2] + maxValue);
            } else {
                maxValue = Math.max(maxValue, timeValue[2]);
            }
        }

        return ans;
    }
}