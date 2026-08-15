1class Solution {
2    public int mySqrt(int x) {
3        if (x < 2) {
4            return x;
5        }
6
7        long left = 1;
8        long right = x;
9        int ans = 1;
10
11        while (left <= right) {
12            long mid = left + (right - left) / 2;
13
14            if (mid * mid <= x) {
15                ans = (int) mid;
16                left = mid + 1;
17            } else {
18                right = mid - 1;
19            }
20        }
21
22        return ans;
23    }
24}