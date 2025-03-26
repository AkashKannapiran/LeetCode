class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> arrayForm = new ArrayList<>();
        
        for (int i = num.length - 1; i >= 0; --i) {
            arrayForm.add((num[i] + k) % 10);
            k =  (num[i] + k) / 10;
        }

        while (k > 0) {
            arrayForm.add(k % 10);
            k /= 10;
        }

        Collections.reverse(arrayForm);

        return arrayForm;
    }
}