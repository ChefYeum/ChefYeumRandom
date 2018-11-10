
def prime(nth):
	count = 1
	current = 2
	prime_list = [2]
	while count < nth:
		current += 1
		div = False
		for p in prime_list:
			if current%p == 0:
				div = True
				break
		if div == False:
			prime_list.append(current)
			count += 1
	return (current)




if __name__ == "__main__":
	print (prime(10001))
 
		
