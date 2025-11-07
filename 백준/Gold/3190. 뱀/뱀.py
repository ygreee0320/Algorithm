from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
board = [[-1] * (n + 1) for _ in range(n + 1)]

k = int(input())
for _ in range(k):
    a, b = map(int, input().split())
    board[a][b] = 1

l = int(input())
rots = []
for _ in range(l):
    x, c = input().split()
    rots.append([int(x), c])

nx, ny = 1, 1
board[nx][ny] = 0
rot_current = 0
rot_idx = 0

tail = deque()
tail.append((nx, ny))

res = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

while 0 < nx <= n and 0 < ny <= n:
    if rot_idx < len(rots) and res == rots[rot_idx][0]:
        if rots[rot_idx][1] == 'L':
            rot_current = (rot_current + 3) % 4
        else:
            rot_current = (rot_current + 1) % 4
        rot_idx += 1

    nx += dx[rot_current]
    ny += dy[rot_current]

    if 0 < nx <= n and 0 < ny <= n:
        if board[nx][ny] == 0:
            res += 1
            break
        elif board[nx][ny] == 1:
            board[nx][ny] = 0
            tail.append((nx, ny))
        else:
            tx, ty = tail.popleft()
            board[tx][ty] = -1
            board[nx][ny] = 0
            tail.append((nx, ny))

    res += 1
    
print(res)