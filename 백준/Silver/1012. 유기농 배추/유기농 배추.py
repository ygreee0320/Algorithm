from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0] # 상, 하, 좌, 우
dy = [0, 0, -1, 1]


def bfs(sx, sy):
    global data, cnt

    q = deque()
    q.append((sx, sy))

    while q:
        x, y = q.pop()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if data[nx][ny] == 1:
                data[nx][ny] = 0
                q.append((nx, ny))
    cnt += 1


T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    data = [[0 for _ in range(N)] for _ in range(M)]
    cnt = 0

    for _ in range(K):
        X, Y = map(int, input().split())
        data[X][Y] = 1

    for i in range(M):
        for j in range(N):
            if data[i][j] == 1:
                bfs(i, j)
    print(cnt)