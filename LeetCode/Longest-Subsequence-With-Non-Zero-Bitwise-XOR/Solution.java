1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int xor = 0;
4        
5        for (int num : nums) {
6            xor ^= num;
7        }
8        
9        if (xor != 0) {
10            return nums.length;
11        }
12        
13        for (int num : nums) {
14            if (num != 0) {
15                return nums.length - 1;
16            }
17        }
18        
19        return 0;
20    }
21}