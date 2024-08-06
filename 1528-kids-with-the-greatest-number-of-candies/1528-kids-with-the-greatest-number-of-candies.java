class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;

        for (int i : candies) {
            maxCandies = Math.max(i, maxCandies);
        }

        List<Boolean> isGreatest = new ArrayList<>();

        for (int i : candies) {
            if (i + extraCandies >= maxCandies) {
                isGreatest.add(true);
            } else {
                isGreatest.add(false);
            }
        }

        return isGreatest;
    }
}