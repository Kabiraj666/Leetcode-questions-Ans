1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder ans = new StringBuilder();
4        int i = a.length() - 1;
5        int j = b.length() - 1;
6        int carry = 0;
7
8        while (i >= 0 || j >= 0 || carry != 0) {
9            int sum = carry;
10
11            if (i >= 0) {
12                sum += a.charAt(i) - '0';
13                i--;
14            }
15
16            if (j >= 0) {
17                sum += b.charAt(j) - '0';
18                j--;
19            }
20
21            ans.append(sum % 2);
22            carry = sum / 2;
23        }
24
25        return ans.reverse().toString();
26    }
27}