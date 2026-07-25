1class Solution {
2    public long gcdSum(int[] nums) {
3        int n = nums.length;
4        int[] prefixGcd = new int[n];
5
6        int mx = 0;
7        for (int i = 0; i < n; i++) {
8            mx = Math.max(mx, nums[i]);
9            prefixGcd[i] = gcd(nums[i], mx);
10        }
11
12        Arrays.sort(prefixGcd);
13
14        long ans = 0;
15        int left = 0;
16        int right = n - 1;
17
18        while (left < right) {
19            ans += gcd(prefixGcd[left], prefixGcd[right]);
20            left++;
21            right--;
22        }
23
24        return ans;
25    }
26
27    private int gcd(int a, int b) {
28        while (b != 0) {
29            int temp = a % b;
30            a = b;
31            b = temp;
32        }
33        return a;
34    }
35}