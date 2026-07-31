1import java.util.Arrays;
2
3class Solution {
4    public int minimumPushes(String word) {
5        int[] freq = new int[26];
6        for (char c : word.toCharArray()) {
7            freq[c - 'a']++;
8        }
9        
10
11        Arrays.sort(freq);
12        
13        int totalPushes = 0;
14        int distinctChars = 0;
15        
16        
17        for (int i = 25; i >= 0; i--) {
18            if (freq[i] == 0) {
19                break;
20            }
21            
22            int pushesPerChar = (distinctChars / 8) + 1;
23            totalPushes += freq[i] * pushesPerChar;
24            distinctChars++;
25        }
26        
27        return totalPushes;
28    }
29}
30