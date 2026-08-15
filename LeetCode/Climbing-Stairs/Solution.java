1class Solution {
2    public int climbStairs(int n) {
3        if(n<=2){
4        return n;}
5        int a=1;
6        int b=2;
7        for(int i=3; i<=n; i++){
8            int c =a+b;
9            a=b;
10            b=c;
11
12        }
13        return b;
14    }
15
16
17}