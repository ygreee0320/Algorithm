import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 0, 1]
dy = [0, 1, -1, 0]


def bfs(x, y):
    q = deque()
    q.append([x, y])
    data[y][x] = 1
    res = 1

    while q:
        px, py = q.popleft()

        for i in range(4):
            nx = px + dx[i]
            ny = py + dy[i]

            if 0 <= nx < n and 0 <= ny < m and data[ny][nx] == 0:
                data[ny][nx] = 1
                q.append([nx, ny])
                res += 1

    return res


m, n, k = map(int, input().split())
data = [[0] * n for _ in range(m)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(x1, x2):
        for j in range(y1, y2):
            data[j][i] = -1

cnt = 0
area = []
for i in range(n):
    for j in range(m):
        if data[j][i] == 0:
            area.append(bfs(i, j))
            cnt += 1

area.sort()
print(cnt)
print(*area)