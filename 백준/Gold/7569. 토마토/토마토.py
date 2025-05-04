from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0, 0, 0]  # 상, 하, 좌, 우, 위, 아래
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]


def bfs(start):
    global cnt_done
    q = deque()
    q.extend(start)
    result = 1

    while q:
        x, y, z = q.popleft()
        if tomato[z][x][y] > result:
            result = tomato[z][x][y]

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if nx < 0 or ny < 0 or nz < 0 or nx >= N or ny >= M or nz >= H:
                continue
            if tomato[nz][nx][ny] == 0:
                tomato[nz][nx][ny] = tomato[z][x][y] + 1
                cnt_done += 1
                q.append((nx, ny, nz))

    if cnt_done == cnt:
        print(result - 1)
    else:
        print(-1)


M, N, H = map(int, input().split())
tomato = [[] for _ in range(H)]
start = []
cnt = 0
cnt_done = 0

for i in range(H):
    for j in range(N):
        a = list(map(int, input().split()))
        tomato[i].append(a)

        for k, value in enumerate(a):
            if value == -1:
                continue
            if value == 1:
                start.append((j, k, i))
                cnt_done += 1
            cnt += 1

if len(start) == cnt:
    print(0)
else:
    bfs(start)