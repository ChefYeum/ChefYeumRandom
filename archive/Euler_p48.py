def last_digit(n):
	number = str(n)
	return int(number[len(number)-1])

def self_power(n):
	sum = 0
	for i in range(1,n+1):
		current = last_digit(i)
		current = last_digit(current**current)
		print (i," to ", i, " equals to :", current)
		sum += last_digit(current)
		# print ("Hence the sum is: ", sum)

	return last_digit(sum)




if __name__ == "__main__":
	# print (self_power(1000))
	sum = 0
	for i in range(1,1000+1):
		print ("Self power of ", i)
		sum += (i**i)
	sum = str(sum)
	print (sum[len(sum)-10:len(sum)])