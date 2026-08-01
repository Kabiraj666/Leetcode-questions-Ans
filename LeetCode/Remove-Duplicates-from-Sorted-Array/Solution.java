1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if(nums.length == 0)
4        return 0;
5        int i = 0;
6        for(int j =1; j < nums.length ; j++)
7    {
8        if(nums[i] != nums[j]){
9            i++;
10            nums[i] = nums[j];
11
12        }
13
14    }
15    return i+1;
16        
17    }
18}