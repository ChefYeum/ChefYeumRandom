




if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        nums, n = [1,2,3,5,8], 13
        limit = int(input())
        while n < limit:
            nums.append(n)
            lastPos = len(nums)-1
            n = nums[lastPos] + nums[lastPos-1]
        print (sum(list(filter(lambda x: x % 2 == 0, nums))))

