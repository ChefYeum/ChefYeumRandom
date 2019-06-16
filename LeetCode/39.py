from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if target == 0:
            return []
        else:
            candidates = list(sorted(filter(lambda x: x < target, candidates)))
            

