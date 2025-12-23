import sys
input = sys.stdin.readline

N = int(input())
top = list(map(int, input().split()))
res = [0] * N
max_top = []

for i in range(N):
    if max_top:
        for j in range(len(max_top) - 1, -1, -1):
            if top[i] <= max_top[j][0]:
                res[i] = max_top[j][1]
                break
            else:
                max_top.pop()

    max_top.append([top[i], i + 1])

print(*res)