def sumSq(n):
    return n*(n+1)*(2*n+1)/6

def sqSum(n):
    return (n*(n+1)/2)**2

repeat = int(input())
for i in range(repeat):
    n = int(input())
    print (int(abs(sumSq(n)-sqSum(n))))