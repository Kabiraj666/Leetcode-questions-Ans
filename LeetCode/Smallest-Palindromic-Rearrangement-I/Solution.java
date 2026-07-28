class Solution:
   def smallestPalindrome(self, s: str) -> str:
       if len(s) <= 1:
           return s

       hashMap = [0]*26
       n = len(s)
       for i in range(n // 2):
           hashMap[ord(s[i]) % ord('a')] += 2
       
       if n % 2 != 0:
           hashMap[ord(s[n//2]) % ord('a')] += 1
       
       res = [""] * len(s)
       i = 0
       for j in range(26):
           if hashMap[j] % 2 != 0:
               print(hashMap[j])
               res[n // 2] = chr(ord('a') + j)
               hashMap[j] -= 1
           for k in range(hashMap[j] // 2):
               res[i] = res[-(i+1)] = chr(ord('a') + j)
               i+= 1
       
       return "".join(res)