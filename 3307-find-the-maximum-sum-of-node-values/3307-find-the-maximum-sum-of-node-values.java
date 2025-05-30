class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int positiveMinimum = (1 << 30);
        int negativeMaximum = -1 * (1 << 30);

        for (int nodeValue : nums) {
            int operatedNodeValue = nodeValue ^ k;
            sum += nodeValue;
            int netChange = operatedNodeValue - nodeValue;

            if (netChange > 0) {
                positiveMinimum = Math.min(positiveMinimum, netChange);
                sum += netChange;
                count++;
            } else {
                negativeMaximum = Math.max(negativeMaximum, netChange);
            }
        }

        if (count % 2 == 0) {
            return sum;
        }

        return Math.max(sum - positiveMinimum, sum + negativeMaximum);
    }
}