#!/bin/python3

import sys

def prodStr(str):
    prod = 1
    for c in str:
        prod *= int(c)
    return prod

t = int(input().strip())
for a0 in range(t):
    n,k = input().strip().split(' ')
    n,k = int(n), int(k)
    num = input().strip()
    prod = []
    for i in range(n):
        endPos = i+k
        if endPos < n:
            prod.append(prodStr(num[i:i+k]))
    print (max(prod))