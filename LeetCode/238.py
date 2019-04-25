def productExceptSelf(nums):
	output = [1] * len(nums)

	for i in range(1, len(nums)):
		output[i] *= nums[i-1] * output[i-1]

	temp = 1
	for i in range(len(nums)-1,-1,-1):
		output[i] *= temp
		temp *= nums[i]	
	
	return (output)



if __name__ == "__main__":
	print (productExceptSelf([10,10,10,10]))

