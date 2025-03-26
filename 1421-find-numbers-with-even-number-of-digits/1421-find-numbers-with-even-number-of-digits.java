class Solution {
    public int findNumbers(int[] nums) {
        int countOfEvenDigits = 0;

        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || (num == 100000)) {
                countOfEvenDigits++;
            }
        }

        return countOfEvenDigits;
    }
}