def nth_fibonacci(n):
	if n == 0 or n == 1:
		return 1
	else:
		return nth_fibonacci(n-1) + nth_fibonacci(n-2)

list = [1,1]

position = 2
while len(str(list[len(list)-1])) < 1000:
	list.append(list[position-2]+list[position-1])
	position += 1

print (len(list))