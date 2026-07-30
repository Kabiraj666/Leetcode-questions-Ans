1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4        
5        if (n <= 8) {
6            return n * 1;
7        } else if (n <= 16) {
8            return 8 * 1 + (n - 8) * 2;
9        } else if (n <= 24) {
10            return 8 * 1 + 8 * 2 + (n - 16) * 3;
11        } else {
12            return 8 * 1 + 8 * 2 + 8 * 3 + (n - 24) * 4;
13        }
14    }
15}