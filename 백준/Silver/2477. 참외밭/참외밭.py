import sys
input = sys.stdin.readline

k = int(input())

max_w = 0
max_h = 0
data = []
ex = []

for _ in range(6):
    d, l = map(int, input().split())
    data.append((d, l))

    if d == 1 or d == 2:
        max_w = max(max_w, l)
    else:
        max_h = max(max_h, l)

for i in range(6):
    if data[i][0] == data[(i + 2) % 6][0]:
        ex.append(data[(i + 1) % 6][1])

res = (max_w * max_h - ex[0] * ex[1]) * k
print(res)