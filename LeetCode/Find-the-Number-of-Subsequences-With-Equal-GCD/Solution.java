1class Solution {
2    static final int MOD = 1_000_000_007;
3
4    public int subsequencePairCount(int[] nums) {
5        int max = 0;
6        for (int x : nums) max = Math.max(max, x);
7
8        long[][] dp = new long[max + 1][max + 1];
9        dp[0][0] = 1;
10
11        for (int num : nums) {
12            long[][] next = new long[max + 1][max + 1];
13
14            for (int g1 = 0; g1 <= max; g1++) {
15                for (int g2 = 0; g2 <= max; g2++) {
16                    if (dp[g1][g2] == 0) continue;
17
18                    // Ignore current number
19                    next[g1][g2] = (next[g1][g2] + dp[g1][g2]) % MOD;
20
21                    // Put in first subsequence
22                    int ng1 = (g1 == 0) ? num : gcd(g1, num);
23                    next[ng1][g2] = (next[ng1][g2] + dp[g1][g2]) % MOD;
24
25                    // Put in second subsequence
26                    int ng2 = (g2 == 0) ? num : gcd(g2, num);
27                    next[g1][ng2] = (next[g1][ng2] + dp[g1][g2]) % MOD;
28                }
29            }
30
31            dp = next;
32        }
33
34        long ans = 0;
35        for (int g = 1; g <= max; g++) {
36            ans = (ans + dp[g][g]) % MOD;
37        }
38
39        return (int) ans;
40    }
41
42    private int gcd(int a, int b) {
43        while (b != 0) {
44            int t = a % b;
45            a = b;
46            b = t;
47        }
48        return a;
49    }
50}