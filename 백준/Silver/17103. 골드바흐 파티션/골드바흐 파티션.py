import sys
input = sys.stdin.readline
INF = 1000001

primes = [True for _ in range(INF)]
for i in range(2, INF):
    if primes[i]:
        for j in range(i * 2, INF, i):
            primes[j] = False

T = int(input())

for _ in range(T):
    N = int(input())
    res = 0

    for i in range(2, N // 2 + 1):
        if primes[i] and primes[N - i]:
            res += 1

    print(res)