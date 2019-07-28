from typing import List 

class Solution:
    def first(nums, condition):
        for n in nums:
            if condition(n):
                return n:

    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        return list(map(lambda t: T[t[0]+1:].index(t[1]) if (t[1] in T[t[0]+1:]) else 0, enumerate(T)))


if __name__ == "__main__":
    s = Solution()
    ans = s.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73])
    print(ans) 
