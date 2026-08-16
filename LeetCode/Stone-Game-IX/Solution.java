1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int[] count = new int[3];
4
5        for (int stone : stones) {
6            count[stone % 3]++;
7        }
8
9        if (count[0] % 2 == 0) {
10            return count[1] > 0 && count[2] > 0;
11        }
12
13        return Math.abs(count[1] - count[2]) > 2;
14    }
15}