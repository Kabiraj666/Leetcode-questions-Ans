1class Solution {
2    public int lengthOfLastWord(String s) {
3
4        int length = 0;
5        int i = s.length() - 1;
6
7        while (i >= 0 && s.charAt(i) == ' ') {
8            i--;
9        }
10
11        while (i >= 0 && s.charAt(i) != ' ') {
12            length++;
13            i--;
14        }
15
16        return length;
17    }
18}