import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 0, 1]
dy = [0, 1, -1, 0]


def bfs_water():
    q = deque()
    q += water_start

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C and water[nx][ny] == -1:
                water[nx][ny] = water[x][y] + 1
                q.append((nx, ny))


def bfs():
    q = deque()
    q.append((sx, sy))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                if forest[nx][ny] == 'D':
                    print(forest[x][y] + 1)
                    exit()

                if forest[nx][ny] == '.':
                    if water[nx][ny] == -1 or water[nx][ny] > (forest[x][y] + 1):
                        forest[nx][ny] = forest[x][y] + 1
                        q.append((nx, ny))

    print('KAKTUS')


R, C = map(int, input().split())
forest = []
water = [[-1] * C for _ in range(R)]
water_start = []
sx, sy = 0, 0
ex, ey = 0, 0

for i in range(R):
    forest.append(list(input().rstrip()))

    for j in range(C):
        if forest[i][j] == '*':
            water_start.append((i, j))
            water[i][j] = 0

        elif forest[i][j] == 'S':
            sx, sy = i, j
            forest[i][j] = int(0)

        elif forest[i][j] == 'D':
            ex, ey = i, j
            water[i][j] = -2  # 불가

        elif forest[i][j] == 'X':
            water[i][j] = -2

bfs_water()
bfs()