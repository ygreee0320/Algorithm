from collections import deque

dx = [-1, -2, -2, -1, 1, 2, 2, 1]
dy = [-2, -1, 1, 2, -2, -1, 1, 2]


def bfs(sx, sy, tx, ty):
    q = deque()
    q.append((sx, sy))

    while q:
        x, y = q.popleft()
        if x == tx and y == ty:
            print(cnt[x][y] - 1)
            return True

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= I or ny >= I:
                continue
            if cnt[nx][ny] == 0:
                cnt[nx][ny] = cnt[x][y] + 1
                q.append((nx, ny))

    return False


T = int(input())
for i in range(T):
    I = int(input())
    cnt = [[0] * I for _ in range(I)]
    sx, sy = map(int, input().split())
    tx, ty = map(int, input().split())
    cnt[sx][sy] = 1
    bfs(sx, sy, tx, ty)