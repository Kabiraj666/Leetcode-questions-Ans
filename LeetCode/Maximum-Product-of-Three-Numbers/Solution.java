1class Solution {
2    public int maximumProduct(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5
6        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
7        int product2 = nums[0] * nums[1] * nums[n - 1];
8
9        return Math.max(product1, product2);
10    }
11}