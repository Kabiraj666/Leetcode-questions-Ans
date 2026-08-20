1import java.util.*;
2
3class Solution {
4    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
5        Map<Integer, Integer> map = new HashMap<>();
6
7        for (int[] seat : reservedSeats) {
8            int row = seat[0];
9            int col = seat[1];
10            map.put(row, map.getOrDefault(row, 0) | (1 << col));
11        }
12
13        int answer = (n - map.size()) * 2;
14
15        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
16        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
17        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
18
19        for (int reserved : map.values()) {
20            if ((reserved & left) == 0 && (reserved & right) == 0) {
21                answer += 2;
22            } else if ((reserved & left) == 0 ||
23                       (reserved & middle) == 0 ||
24                       (reserved & right) == 0) {
25                answer += 1;
26            }
27        }
28
29        return answer;
30    }
31}