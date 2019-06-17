from typing import List

class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        jobs = zip(difficulty,profit) 
        return self.getProfit(jobs,sorted(worker,reverse=True))
    def getProfit(self, jobs: List[tuple], workers: List[int]) -> int:
        if jobs == [] or workers == []:
            return 0
        else:
            currentWorker = workers[0]
            jobs = list(filter(lambda t: t[0] <= currentWorker, jobs))
            # print ("Current Worker: ", currentWorker)
            # print ("Filtered Jobs: ", list(jobs))
            getMax = max(jobs, key=lambda t: t[1], default=(0,0))
            # print ("Max: ", getMax)
            return getMax[1] + self.getProfit(jobs, workers[1:])
        
if __name__ == "__main__":
    s = Solution()

    print("final: ", s.maxProfitAssignment([85,47,57],[24,66,99],[40,25,25]), "\n\n\n")
    print("final: ", s.maxProfitAssignment([2,4,6,8,10],[10,20,30,40,50],[4,5,6,7]))
