import copy
import itertools

class Solution:
    def maxEnvelopes(self, envelopes) -> int:
        if len(envelopes) == 0:
            return 0
        byWidth = sorted(copy.deepcopy(envelopes), key=lambda pair: pair[0], reversed=True)
        byHeight = sorted(envelopes, key=lambda pair: pair[1])
        
        maxEnv = 1

        for w in byWidth:
            height = w[1]
            currentSize= 1
            for h in byHeight:
                if h[1] < height:
                    currentSize += 1
                    height
            num = len(itertools.takewhile(lambda w: w[1] < height, byHeight))
            maxEnv = max(num,maxEnv)

        return maxEnv

if __name__ == "__main__":
        s = Solution()
        print(s.maxEnvelopes([[5,4],[6,4],[6,7],[2,3]]))
