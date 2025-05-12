class Solution {
    public int[] findEvenNumbers(int[] digits) {
        TreeSet<Integer> nums = new TreeSet<>();
        
        for (int i = 0; i < digits.length; ++i) {
            for (int j = 0; j < digits.length; ++j) {
                for (int k = 0; k < digits.length; ++k) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    int num = (digits[i] * 100) + (digits[j] * 10) + digits[k];

                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }

        int[] result = new int[nums.size()];

        for (int i = 0; i < result.length; ++i) {
            result[i] = nums.pollFirst();
        }

        return result;
    }
}