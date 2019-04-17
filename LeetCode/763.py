class Solution(object):
    def partitionLabels(self, S): 
        intervals = [[S.index(S[0]),S.rindex(S[0])]]
        lastInterval = intervals[-1]

        for letter in list(dict.fromkeys(S))[1:]:
            #If overlaps, merge the new interval with the last interval
            if lastInterval[1] >=  S.index(letter): 
                lastInterval[1] = max(lastInterval[1],S.rindex(letter))
            #Otherwise (if they do not overlap), add it as a new interval and set that as the last interval
            else:
                intervals.append([S.index(letter),S.rindex(letter)])
                lastInterval = intervals[-1]
        
        return list(map(lambda t: t[1]-t[0]+1, intervals))


if __name__ == "__main__":
	s = Solution()
	print (list(s.partitionLabels("ababcbacadefegdehijhklij"))==[9,7,8])
	print (list(s.partitionLabels("abbbacddacaaab"))==[14])
