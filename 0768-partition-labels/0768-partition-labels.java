class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> partitionSize = new ArrayList<>();
        int size = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            size++;
            end = (end > lastIndex.get(s.charAt(i))) ? end : lastIndex.get(s.charAt(i));
            if (i == end) {
                partitionSize.add(size);
                size = 0;
            }
        }

        return partitionSize;
    }
}