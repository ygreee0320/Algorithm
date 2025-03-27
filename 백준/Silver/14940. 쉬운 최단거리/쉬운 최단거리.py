import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 0, 1]  # 상, 하, 우, 좌
dy = [0, -1, 1, 0]


def bfs(sx, sy):
    q = deque()
    q.append((sx, sy))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if result[nx][ny] < 0:
                result[nx][ny] = result[x][y] + 1
                q.append((nx, ny))


n, m = map(int, input().split())
data = []
result = [[0 for _ in range(m)] for _ in range(n)]
target_x, target_y = 0, 0

for i in range(n):
    a = list(map(int, input().split()))
    data.append(a)

    for j, value in enumerate(a):
        if value == 2:
            target_x = i
            target_y = j
        elif value == 1:
            result[i][j] = -1

bfs(target_x, target_y)

for i in result:
    print(*i)