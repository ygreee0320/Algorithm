import sys
input = sys.stdin.readline


def calculate(x, y):
    res = x
    while res <= M * N:
        if (res - x) % M == 0 and (res - y) % N == 0:
            return res
        res += M

    return -1


T = int(input())
for _ in range(T):
    M, N, X, Y = map(int, input().split())

    print(calculate(X, Y))