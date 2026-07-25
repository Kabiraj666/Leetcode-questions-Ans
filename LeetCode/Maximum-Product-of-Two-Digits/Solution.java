1class Solution {
2    public int maxProduct(int n) {
3        int first = 0;
4        int second = 0;
5
6        while (n > 0) {
7            int digit = n % 10;
8
9            if (digit >= first) {
10                second = first;
11                first = digit;
12            } else if (digit > second) {
13                second = digit;
14            }
15
16            n /= 10;
17        }
18
19        return first * second;
20    }
21}