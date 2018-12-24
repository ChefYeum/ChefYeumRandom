def palind(strNum): 
    mid = round(len(strNum)/2) 
    if strNum[0:mid] == strNum[mid+1:len(strNum)][::-1]: 
        return True 
    else: 
        return False 

import random

def test():
    n = random.randint(0,10)
    head = random.randint(0,9)*n
    num = head +  + head.reverse()


if __name__ == "__main__":
    n = 123456 #limit
    palindList = []
    for outer in range(1000):
        for inner in range(1000):
            prod = outer * inner
            if prod < n:
                break
            elif palind(prod):
                palindList.append(prod)
    print (max(palindList))



