1class Solution {
2    public int[] validSequence(String word1, String word2) {
3        int n = word1.length();
4        int m = word2.length();
5        
6        int[] lastPos = new int[m];
7        for (int k = 0; k < m; k++) {
8            lastPos[k] = -1;
9        }
10        
11        int ptr = n - 1;
12        for (int j = m - 1; j >= 0; j--) {
13            while (ptr >= 0 && word1.charAt(ptr) != word2.charAt(j)) {
14                ptr--;
15            }
16            lastPos[j] = ptr;
17            if (ptr >= 0) {
18                ptr--;
19            }
20        }
21        
22        int[] res = new int[m];
23        boolean usedMismatch = false;
24        int j = 0;
25        
26        for (int i = 0; i < n && j < m; i++) {
27            boolean isMatch = word1.charAt(i) == word2.charAt(j);
28            
29            if (isMatch) {
30                res[j] = i;
31                j++;
32            } else if (!usedMismatch) {
33                boolean canChange = (j == m - 1) || (i < lastPos[j + 1]);
34                if (canChange) {
35                    res[j] = i;
36                    usedMismatch = true;
37                    j++;
38                }
39            }
40        }
41        
42        return j == m ? res : new int[0];
43    }
44}