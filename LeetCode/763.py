class Solution(object):
    def partitionLabels(self, S): 
		
		#1. Get the intervals for each unique character i.e. each pair of [first occured index, last occured index]
        intervals = []
        for letter in set(S):
            intervals.append([S.index(letter),S.rindex(letter)])
		
		#2. Sort the inverals by the start of the interval
        intervals.sort(key=lambda t: t[0])
	
		#3. Merge any overlapped intervals
        i = 0 
        while (i < len(intervals)-1):
            if (intervals[i][1] >= intervals[i+1][0]):
                intervals[i][1] = max(intervals[i+1][1], intervals[i][1])
                del(intervals[i+1])
            else:
                i += 1
				
		#4. Map a lambda function to get the length of each interval and return it
        return map(lambda t: t[1]-t[0]+1, intervals)


if __name__ == "__main__":
	s = Solution()
	print (list(s.partitionLabels("ababcbacadefegdehijhklij"))==[9,7,8])
	print (list(s.partitionLabels("abbbacddacaaab"))==[14])
