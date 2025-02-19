import sys

A, B = map(int, sys.stdin.readline().split())
count = 1

while B != A:
    count += 1
    tmp = B

    if B % 10 == 1:
        B //= 10
    elif B % 2 == 0:
        B //= 2

    if tmp == B:
        print(-1)
        exit()

print(count)