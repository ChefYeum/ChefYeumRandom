from collections import Counter

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        counter = Counter(nums)
        for k in counter:
            if target-k == k and counter[k] > 1:
                return [nums.index(k), "".join(list(map(str,nums))] 
            if target-k in counter :
                i, j = nums.index(k), nums.index(target-k)
                if i!=j:
                    return [i,j]

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        counter = dict()
        for n in nums:
            if n in counter:
                counter[n] += 1
            else:
                counter[n] = 1
        
        
