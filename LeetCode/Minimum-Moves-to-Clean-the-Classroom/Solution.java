1import java.util.*;
2
3class Solution {
4    public int minMoves(String[] classroom, int energy) {
5        int m = classroom.length;
6        int n = classroom[0].length();
7
8        int sr = 0, sc = 0;
9        int litterCount = 0;
10
11        int[][] id = new int[m][n];
12
13        for (int[] row : id) {
14            Arrays.fill(row, -1);
15        }
16
17        for (int i = 0; i < m; i++) {
18            for (int j = 0; j < n; j++) {
19                char ch = classroom[i].charAt(j);
20
21                if (ch == 'S') {
22                    sr = i;
23                    sc = j;
24                } else if (ch == 'L') {
25                    id[i][j] = litterCount++;
26                }
27            }
28        }
29
30        int fullMask = (1 << litterCount) - 1;
31
32        Queue<int[]> q = new LinkedList<>();
33
34        boolean[][][][] visited =
35                new boolean[m][n][1 << litterCount][energy + 1];
36
37        q.offer(new int[]{sr, sc, 0, energy, 0});
38        visited[sr][sc][0][energy] = true;
39
40        int[] dr = {-1, 1, 0, 0};
41        int[] dc = {0, 0, -1, 1};
42
43        while (!q.isEmpty()) {
44            int[] cur = q.poll();
45
46            int r = cur[0];
47            int c = cur[1];
48            int mask = cur[2];
49            int e = cur[3];
50            int moves = cur[4];
51
52            if (mask == fullMask) {
53                return moves;
54            }
55
56            for (int d = 0; d < 4; d++) {
57                int nr = r + dr[d];
58                int nc = c + dc[d];
59
60                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
61                    continue;
62                }
63
64                if (classroom[nr].charAt(nc) == 'X') {
65                    continue;
66                }
67
68                if (e == 0) {
69                    continue;
70                }
71
72                int ne = e - 1;
73                int nmask = mask;
74
75                char ch = classroom[nr].charAt(nc);
76
77                if (ch == 'L') {
78                    nmask |= 1 << id[nr][nc];
79                }
80
81                if (ch == 'R') {
82                    ne = energy;
83                }
84
85                if (!visited[nr][nc][nmask][ne]) {
86                    visited[nr][nc][nmask][ne] = true;
87
88                    q.offer(new int[]{
89                        nr, nc, nmask, ne, moves + 1
90                    });
91                }
92            }
93        }
94
95        return -1;
96    }
97}