def countSteps(piles):
    output = 0
    lastCount = 0
    nums = (sorted(list(set(piles)),reverse=True)[:-1])
    print (nums)
    for nextMax in nums:
        lastCount = piles.count(nextMax) + lastCount
        output += lastCount 
    return output 

def counterSteps(piles):
    from collections import Counter
    c = Counter(piles)
    output = 0
    piles = sorted(c.items(), key=lambda pair: pair[0], reverse=True)
    piles.pop()
    for n in piles:
        output = 2*output+n[1]
    return output
        
def check(f):
    from random import randint
    for repeat in range(10):
        n = randint(0,2*(10**5)) 
        piles = [randint(0,10**6) for x in range(n)] 
    print ("Done")

def quickCheck(f1,f2):
    from random import randint
    for repeat in range(1000):
        n = randint(1,(10)) 
        piles = [randint(1,2*10) for x in range(n)] 
        
        result1 = f1(piles)
        result2 = f2(piles)
        
        print ("FP: ", result1)
        print ("OOP: ", result2)


        if result1 != result2:
            print ("Falsified by %s and %s!\n" % (n, piles))
            return False 
        else:
            print ("Proved true by %s and %s!\n" % (n, piles))
    else:
        return True

if __name__ == "__main__":
    #quickCheck(counterSteps,countSteps)
    dummy = [17, 17, 19, 7, 7, 14]
    print (countSteps(dummy))
    
