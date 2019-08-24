from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        def findFstWarmerPos(start):
            count = 1
            for end in range(start+1,len(T)):
                if T[start] < T[end]:
                    return count
                else:
                    count += 1

            else:
                return 0
        return [findFstWarmerPos(x) for x in range(len(T))]

if __name__ == "__main__":
    s = Solution()
    print (s.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
    print (f"Expected: [1, 1, 4, 2, 1, 1, 0, 0]")
    
