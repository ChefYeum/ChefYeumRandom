"""
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
"""

import itertools
from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
       print (list(itertools.combinations(range(1,n+1),k)))             



if __name__ == "__main__":
    s = Solution()
    s.combine(10,2)




