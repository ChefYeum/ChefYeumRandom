# Sum of prime up to 2 million 2000000

def prime_check(number):  # Only works for n>1
	prime = True
	for d in range(2, number):
		if number % d == 0:
			prime = False
	return prime


if __name__ == '__main__':
	list_prime = [2]
	sum = 2
	for n in range(3, 2000000, 2):
		divisible = False
		for p in list_prime:
			if n % p == 0:
				divisible = True
				break
		if divisible == False:
			list_prime.append(n)
			sum += n
			print("n = ", n)
			print(list_prime)
	print (sum)
