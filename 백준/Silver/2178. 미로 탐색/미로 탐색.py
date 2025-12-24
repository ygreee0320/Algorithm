import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 0, 1]
dy = [0, 1, -1, 0]


def bfs():
    q = deque()
    q.append([0, 0, 1])
    miro[0][0] = 0

    while q:
        x, y, cnt = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx == M - 1 and ny == N - 1:
                print(cnt + 1)
                exit()

            if 0 <= nx < M and 0 <= ny < N:
                if miro[ny][nx] == 1:
                    q.append([nx, ny, cnt + 1])
                    miro[ny][nx] = 0


N, M = map(int, input().split())
miro = []

for _ in range(N):
    miro.append(list(map(int, input().rstrip())))

bfs()