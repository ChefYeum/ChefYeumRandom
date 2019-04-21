
class Solution:
	def maxProfitAssignment(self, difficulty, profit, worker):
		total = 0
		profitDict = (zip(difficulty,profit))
		return self.rec(diffProf=profitDict,w=sorted(worker, reverse=True)) 

	def rec(self, diffProf, w):
		if w == [] or diffProf == []:
			return 0
		else:
			for t in diffProf:
				print (w[0] >= t[0])
			filteredTup = (map(lambda t: (w[0] >= t[0]), diffProf))  	
			try:
				maxProf = max(filteredTup, key=lambda t: t[0])[0]
			except ValueError:
				maxProf = 0	

			return (maxProf + self.rec(diffProf,w[1:]))
			
							

if __name__ == '__main__':
	s = Solution()
	print("final: ", s.maxProfitAssignment([85,47,57],[24,66,99],[40,25,25]), "\n\n\n")
	print("final: ", s.maxProfitAssignment([2,4,6,8,10],[10,20,30,40,50],[4,5,6,7]))
