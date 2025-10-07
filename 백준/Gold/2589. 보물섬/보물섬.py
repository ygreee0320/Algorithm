from collections import deque
import sys
input = sys.stdin.readline
dx = [-1, 0, 0, 1]
dy = [0, 1, -1, 0]

h, w = map(int, input().split())
graph = []

for i in range(h):
    graph.append(input().rstrip())


def bfs(start_x, start_y):
    visited = [[-1] * w for _ in range(h)]
    q = deque()
    q.append([start_x, start_y])
    visited[start_x][start_y] = 0
    t = 0

    while(q):
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < h and 0 <= ny < w:
                if graph[nx][ny] == 'L' and visited[nx][ny] == -1:
                    q.append([nx, ny])
                    visited[nx][ny] = visited[x][y] + 1
                    t = max(t, visited[nx][ny])

    return t


ans = 0
for i in range(h):
    for j in range(w):
        if graph[i][j] == 'L':
            ans = max(ans, bfs(i, j))

print(ans)