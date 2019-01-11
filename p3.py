def getFactor(n):
    for d in range(2,int(n/2)+1):
        divided = n/d
        if round(divided) == divided:
            return divided
    return 1

if __name__ == "__main__":
    t = int(input().strip())
    for i in range(t):
        n = int(input().strip())
        print(int(getFactor(n)))