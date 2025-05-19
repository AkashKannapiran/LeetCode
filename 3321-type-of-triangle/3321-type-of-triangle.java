class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);

        return (nums[0] + nums[1] <= nums[2]) ? "none"
            : (nums[0] == nums[2]) ? "equilateral"
            : (nums[0] == nums[1] || nums[1] == nums[2]) ? "isosceles"
            : "scalene";
    }
}