
def countSteps(piles):
    output = 0
    lastCount = 0
    nums = (sorted(list(set(piles)),reverse=True)[:-1])
    for nextMax in nums:
        lastCount = piles.count(nextMax) + lastCount
        output += lastCount 
    return output 

def minimumMoves(q):
    from collections import Counter
    C = Counter(q)
    p = sorted(C.items(), key=lambda pair: pair[0], reverse=True)
    p.pop()
    ret = 0
    lastCount = 0
    for (_,b) in p:
        ret += lastCount + b
        lastCount += b
    return ret

def quickCheck(f1,f2):
    from random import randint
    for repeat in range(2):
        n = randint(1,2*(10**4))
        piles = [randint(1,2*(10**5)) for x in range(n)] 
        
        
        result1 = f1(piles[:])
        result2 = f2(piles[:])
        
        print ("FP: ", result1)
        print ("OOP: ", result2)


        if result1 != result2:
            print ("Falsified by %s and %s!\n" % (n, piles))
            return False 
        else:
            print ("Proved true by %s and %s!\n" % (n, piles))
    else:
        return True

def quickCheck(f1,f2):
    from random import randint
    for repeat in range(10):
        n = randint(1,2*(10**5))
        piles = [randint(1,2*(10**5)) for x in range(n)] 
        
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
    print (quickCheck(minimumMoves,countSteps))
    dummy = [17, 17, 19, 7, 7, 14]
    dummy = [13,13,7,7,5,6,3]
    #print (countSteps(dummy))
    
