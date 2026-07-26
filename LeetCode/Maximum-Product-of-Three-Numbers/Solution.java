1class Solution {
2    public int maximumProduct(int[] nums) {
3
4        int max1 = Integer.MIN_VALUE;
5        int max2 = Integer.MIN_VALUE;
6        int max3 = Integer.MIN_VALUE;
7
8        int min1 = Integer.MAX_VALUE;
9        int min2 = Integer.MAX_VALUE;
10
11        for (int num : nums) {
12
13           
14            if (num >= max1) {
15                max3 = max2;
16                max2 = max1;
17                max1 = num;
18            } else if (num >= max2) {
19                max3 = max2;
20                max2 = num;
21            } else if (num >= max3) {
22                max3 = num;
23            }
24
25            
26            if (num <= min1) {
27                min2 = min1;
28                min1 = num;
29            } else if (num <= min2) {
30                min2 = num;
31            }
32        }
33
34        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
35    }
36}