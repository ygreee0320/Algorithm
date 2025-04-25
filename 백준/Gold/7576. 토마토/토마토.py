from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]  # 상, 하, 좌, 우
dy = [0, 0, -1, 1]


def bfs(start):
    global cnt_done
    q = deque()
    q.extend(start)
    result = 1

    while q:
        x, y = q.popleft()
        if tomato[x][y] > result:
            result = tomato[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if tomato[nx][ny] == 0:
                tomato[nx][ny] = tomato[x][y] + 1
                cnt_done += 1
                q.append((nx, ny))

    if cnt_done == cnt:
        print(result - 1)
    else:
        print(-1)


M, N = map(int, input().split())
tomato = []
start = []
cnt = 0
cnt_done = 0

for i in range(N):
    a = list(map(int, input().split()))
    tomato.append(a)

    for j, value in enumerate(a):
        if value == -1:
            continue
        if value == 1:
            start.append((i, j))
            cnt_done += 1
        cnt += 1

if len(start) == cnt:
    print(0)
else:
    bfs(start)