1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length();
4        int half = n / 2;
5
6        int leftSum = 0;
7        int rightSum = 0;
8        int leftQ = 0;
9        int rightQ = 0;
10
11        for (int i = 0; i < half; i++) {
12            if (num.charAt(i) == '?') {
13                leftQ++;
14            } else {
15                leftSum += num.charAt(i) - '0';
16            }
17        }
18
19        for (int i = half; i < n; i++) {
20            if (num.charAt(i) == '?') {
21                rightQ++;
22            } else {
23                rightSum += num.charAt(i) - '0';
24            }
25        }
26
27        int totalQ = leftQ + rightQ;
28
29        if (totalQ % 2 == 1) {
30            return true;
31        }
32
33        int diff = leftSum - rightSum;
34        int required = 9 * (rightQ - leftQ) / 2;
35
36        return diff != required;
37    }
38}