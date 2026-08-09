1class Solution {
2    public int stoneGameII(int[] piles) {
3        int n = piles.length;
4        int[] suffixSum = new int[n];
5        suffixSum[n - 1] = piles[n - 1];
6        for (int i = n - 2; i >= 0; i--) {
7            suffixSum[i] = suffixSum[i + 1] + piles[i];
8        }
9
10        int[][] memo = new int[n][n + 1];
11        return dp(piles, suffixSum, memo, 0, 1);
12    }
13
14    private int dp(int[] piles, int[] suffixSum, int[][] memo, int i, int M) {
15        if (i >= piles.length) {
16            return 0;
17        }
18        if (i + 2 * M >= piles.length) {
19            return suffixSum[i];
20        }
21        if (memo[i][M] != 0) {
22            return memo[i][M];
23        }
24
25        int maxStones = 0;
26        for (int X = 1; X <= 2 * M; X++) {
27            int nextM = Math.max(M, X);
28            int opponentStones = dp(piles, suffixSum, memo, i + X, nextM);
29            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
30        }
31
32        memo[i][M] = maxStones;
33        return maxStones;
34    }
35}