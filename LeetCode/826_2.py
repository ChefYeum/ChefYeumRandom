
class Solution:
	def maxProfitAssignment(self, difficulty, profit, worker):
		total = 0
		profitDict = dict(zip(difficulty,profit))
		for level in worker:
			if level in profitDict:
				total += profitDict[level]
			else:
				filteredList = list(filter(lambda x: x <= level, profitDict.keys()))
				if not filteredList == []:
					total += profitDict[max(filteredList)]
		return total


if __name__ == '__main__':
	s = Solution()
	print(s.maxProfitAssignment([85,47,57],[24,66,99],[40,25,25]))
	print(s.maxProfitAssignment([2,4,6,8,10],[10,20,30,40,50],[4,5,6,7]))
