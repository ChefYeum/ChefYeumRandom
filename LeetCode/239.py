from typing import List
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        outputList = []
        start = 0 
        while start+k < len(nums)+1:
            outputList.append(max(nums[start:start+k]))
            start+=1
        return outputList



if __name__ == '__main__':
    s = Solution()
    print(s.maxSlidingWindow([1,3,-1,-3,5,3,6,7],3))
    
