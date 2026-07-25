1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int max = 0;
4        for (int x : nums) max = Math.max(max, x);
5
6        int[] freq = new int[max + 1];
7        for (int x : nums) freq[x]++;
8
9        long[] cnt = new long[max + 1];
10
11        
12        for (int i = 1; i <= max; i++) {
13            long c = 0;
14            for (int j = i; j <= max; j += i) {
15                c += freq[j];
16            }
17            cnt[i] = c * (c - 1) / 2;
18        }
19
20        
21        for (int i = max; i >= 1; i--) {
22            for (int j = i * 2; j <= max; j += i) {
23                cnt[i] -= cnt[j];
24            }
25        }
26
27       
28        long[] prefix = new long[max + 1];
29        for (int i = 1; i <= max; i++) {
30            prefix[i] = prefix[i - 1] + cnt[i];
31        }
32
33        int[] ans = new int[queries.length];
34
35        for (int k = 0; k < queries.length; k++) {
36            long q = queries[k] + 1; // 1-based position
37
38            int l = 1, r = max;
39            while (l < r) {
40                int mid = l + (r - l) / 2;
41                if (prefix[mid] >= q) {
42                    r = mid;
43                } else {
44                    l = mid + 1;
45                }
46            }
47            ans[k] = l;
48        }
49
50        return ans;
51    }
52}