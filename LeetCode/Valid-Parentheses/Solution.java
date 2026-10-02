1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4         for (char c : s.toCharArray()) {
5             if (c == '(' || c == '[' || c == '{' || c == '|') {
6                stack.push(c);
7             }
8             else{
9                if(stack.isEmpty()) return false;
10                char top = stack.pop();
11                if (c == ')' && top != '(') return false;
12                if (c == ']' && top != '[') return false;
13                if (c == '}' && top != '{') return false;
14
15
16             }
17         }
18         return stack.isEmpty();
19    }
20}