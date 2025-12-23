import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]


def bfs(x, y):
    q = deque()
    q.append([x, y])
    res = 0

    while q:
        px, py = q.popleft()

        for k in range(4):
            nx = px + dx[k]
            ny = py + dy[k]

            if 0 <= nx < N and 0 <= ny < M:
                if campus[nx][ny] == 'O' or campus[nx][ny] == 'P':
                    if campus[nx][ny] == 'P':
                        res += 1

                    q.append([nx, ny])
                    campus[nx][ny] = 'C'

    if res > 0:
        print(res)
    else:
        print('TT')


N, M = map(int, input().split())
campus = []

for _ in range(N):
    campus.append(list(input().rstrip()))

for i in range(N):
    for j in range(M):
        if campus[i][j] == 'I':
            bfs(i, j)