def isPrime(n):
    if n == 2:
        return True
    elif (n % 2 == 0) or n == 1: #If one or an even number that is not two, return false
        return False
    else:
        for d in range(3,n,2): #If divisible by any odd number, return false
            if n % d == 0:
                return False
        return True #otherwise the number is a prime number, hence return true

if __name__ == '__main__':
    t = int(input().strip())
    prod = 1
    for a0 in range(t):
        n = int(input().strip())
        if n >= 2:
            prod = 2
        for x in range(1,n+1,2):
            if isPrime(x):
                prod *= x
        print (prod)

#Attept: product of all prime numbers up to n?? Nope

