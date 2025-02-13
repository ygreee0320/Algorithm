import sys

N, M = map(int, input().split())

d = {}

for i in range(1, N + 1):
    name = sys.stdin.readline().rstrip()
    d[i] = name
    d[name] = i

for j in range(M):
    q = input()

    if q.isdigit():
        print(d[int(q)])
    else:
        print(d[q])