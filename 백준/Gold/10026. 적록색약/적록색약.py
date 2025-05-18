from collections import deque
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

dx = [-1, 1, 0, 0]  # 상, 하, 좌, 우
dy = [0, 0, -1, 1]


def bfs(start):
    q = deque()
    q.append(start)

    while q:
        x, y = q.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx < 0 or ny < 0 or nx >= N or ny >= N or visited[nx][ny]:
                continue
            if picture[nx][ny] == picture[x][y]:
                q.append((nx, ny))
                visited[nx][ny] = True


def bfs_blind(start):
    q = deque()
    q.append(start)

    while q:
        x, y = q.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx < 0 or ny < 0 or nx >= N or ny >= N or visited[nx][ny]:
                continue
            if picture[nx][ny] == picture[x][y]:
                q.append((nx, ny))
                visited[nx][ny] = True
            elif picture[nx][ny] in 'RG' and picture[x][y] in 'RG':
                q.append((nx, ny))
                visited[nx][ny] = True


picture = []

N = int(input())
for _ in range(N):
    picture.append(input().strip())

visited = [[False] * N for _ in range(N)]
cnt_normal = 0

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            visited[i][j] = True
            bfs((i, j))
            cnt_normal += 1

visited = [[False] * N for _ in range(N)]
cnt_blind = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            visited[i][j] = True
            bfs_blind((i, j))
            cnt_blind += 1

print(cnt_normal, cnt_blind)