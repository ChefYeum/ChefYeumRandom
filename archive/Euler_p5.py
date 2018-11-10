#670442572800


def minToMax():
	for i in range(140000000,670442572800):
		valid = True
		for d in [19,11,12,13,14,15,16,17,18,20]:
			if i%d != 0:
				print (i, ' has failed to be divided by ', d)
				valid = False
				break
		if valid == True:
			print (i, 'is the number!!')
			break


def maxToMin():
	min = 0
	for i in range(670442572800,0,-1):
		valid = True
		for d in [19,11,12,13,14,15,16,17,18,20]:
			if i%d != 0:
				print (i, ' has failed to be divided by ', d)
				valid = False
				break
		if valid == True:
			min = (i)
			print ("Current minimum is ", i)

minToMax()



