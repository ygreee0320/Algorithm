import sys

A, B, C = map(int, sys.stdin.readline().split())

def multi(num, c):
    if c == 1:
        return num % C
    else:
        tmp = multi(num, c//2)
        if c % 2 == 0:
            return (tmp * tmp) % C
        else:
            return (tmp * tmp * A) % C

print(multi(A, B))