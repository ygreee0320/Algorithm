from collections import deque
dx = [-1, 0, 0, 1]
dy = [0, 1, -1, 0]

n = int(input())
data = []

for _ in range(n):
    data.append(list(input()))

visited = [[False] * n for i in range(n)]
res = []


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    cnt = 1

    while q:
        a, b = q.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and data[nx][ny] == '1':
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    cnt += 1

    res.append(cnt)


for i in range(n):
    for j in range(n):
        if not visited[i][j] and data[i][j] == '1':
            bfs(i, j)

print(len(res))
res.sort()

for i in res:
    print(i)