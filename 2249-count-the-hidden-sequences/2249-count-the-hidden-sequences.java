class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long gap = 0;
        long minValue = 0;
        long maxValue = 0;
        long currentValue = 0;

        for (int diff : differences) {
            currentValue += diff;
            minValue = Math.min(minValue, currentValue);
            maxValue = Math.max(maxValue, currentValue);
        }

        long count = (upper - lower) - (maxValue - minValue) + 1;
        
        return count > 0 ? (int) count : 0;
    }
}