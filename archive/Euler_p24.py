import math

if __name__ == "__main__":
	number = 0
	for o in range(9,-1,-1):
		fac = math.factorial(o)
		i = 0
		while number+fac < 1000000:
			i += 1
			number += fac
		print (o,"!: ",i )