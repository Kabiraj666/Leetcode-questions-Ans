1import java.util.*;
2
3class Solution {
4    public List<Integer> findMissingElements(int[] nums) {
5        int min = nums[0];
6        int max = nums[0];
7        Set<Integer> set = new HashSet<>();
8        
9        for (int num : nums) {
10            min = Math.min(min, num);
11            max = Math.max(max, num);
12            set.add(num);
13        }
14        
15        List<Integer> result = new ArrayList<>();
16        for (int i = min; i <= max; i++) {
17            if (!set.contains(i)) {
18                result.add(i);
19            }
20        }
21        
22        return result;
23    }
24}