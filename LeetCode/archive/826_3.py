def filterLess(tuples, worker):
    return filter(lambda t: t[0] <= worker, tuples)

class Solution:
    def maxProfitAssignment(self, difficulty, profit, worker):
        total = 0
        profitDict = (zip(difficulty,profit))
        return self.rec(diffProf=profitDict,w=sorted(worker, reverse=True)) 
    def rec(self, diffProf, w):
        if w == [] or diffProf == []:
            return 0
        else:
            filteredTup = filterLess(diffProf,w[0]) 

            if list(filteredTup) == []:
                maxProf = 0
            else:
                maxProf = max(filteredTup, key=lambda t: t[1])[0]

            return (maxProf + self.rec(filteredTup,w[1:]))

if __name__ == '__main__':
    s = Solution()
    print("final: ", s.maxProfitAssignment([85,47,57],[24,66,99],[40,25,25]), "\n\n\n")
    print("final: ", s.maxProfitAssignment([2,4,6,8,10],[10,20,30,40,50],[4,5,6,7]))
    
