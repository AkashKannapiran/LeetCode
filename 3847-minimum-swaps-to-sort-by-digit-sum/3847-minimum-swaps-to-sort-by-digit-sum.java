class Pair {
    int dSum;
    int value;
    int index;

    public Pair(int dSum, int value, int index) {
        this.dSum = dSum;
        this.value = value;
        this.index = index;
    }
    
}
    
class Solution {
    public int minSwaps(int[] nums) {
        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair(digitSum(nums[i]) , nums[i] , i));
        }

        Collections.sort(list, (a, b) -> {
            if (a.dSum == b.dSum) {
                return Integer.compare(a.value, b.value);
            }

            return Integer.compare(a.dSum, b.dSum);
        });

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (list.get(i).index != i) {
                count++;
                swap(list, i, list.get(i).index);
                i--;
            }
        }

        return count;
    }

    private void swap(List<Pair> list, int a, int b) {
        Pair temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }
}