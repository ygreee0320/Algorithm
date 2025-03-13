from collections import deque

def dfs(x, y):
    q = deque()
    q.append((x, y))
    size = 1
    visited[x][y] = True
    global max_size

    # 상, 하, 좌, 우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        a, b = q.popleft()

        for i in range(4):
            nx, ny = a + dx[i], b + dy[i]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and data[nx][ny] == 1:
                q.append((nx, ny))
                visited[nx][ny] = True
                size += 1

    max_size = max(max_size, size)


n, m = map(int, input().split())

data = []
for _ in range(n):
    data.append(list(map(int, input().split())))

cnt = 0
max_size = 0
visited = [[False for i in range(m)] for j in range(n)]

for i in range(n):
    for j in range(m):
        if not visited[i][j] and data[i][j] == 1:
            dfs(i, j)
            cnt += 1

print(cnt)
print(max_size)