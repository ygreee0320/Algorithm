from collections import deque

def right(idx, d):
    if idx > 3:
        return
    if data[idx - 1][2] != data[idx][6]:
        right(idx + 1, -d)
        data[idx].rotate(d)


def left(idx, d):
    if idx < 0:
        return
    if data[idx + 1][6] != data[idx][2]:
        left(idx - 1, -d)
        data[idx].rotate(d)


data = []
for _ in range(4):
    data.append(deque(list(map(int, input()))))

k = int(input())
for _ in range(k):
    a, b = map(int, input().split())
    a -= 1

    right(a + 1, -b)
    left(a - 1, -b)
    data[a].rotate(b)

ans = 0
for i in range(4):
    if data[i][0] == 1:
        ans += 2 ** i

print(ans)