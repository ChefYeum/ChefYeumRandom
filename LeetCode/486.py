class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        p1 = 0
        p2 = 0
        p1Turn = True
        while not nums==[]:
            if nums[-1] > nums[0]:
                p1 += nums.pop(-1)
            elif (nums[-1] == nums[0]):

        


if __name__ == '__main__':
    s = Solution()
    s.PredictTheWinner([1,2,3,4,5,6,7,8,9])
    
