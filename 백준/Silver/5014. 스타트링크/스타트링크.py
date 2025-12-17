import sys
from collections import deque
input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())
visited = [False] * (F + 1)

res = -1
q = deque()
q.append([S, 0])
visited[S] = True

while q:
    n, c = q.popleft()
    if n == G:
        res = c
        break

    nx = n + U
    if U != 0 and 0 < nx <= F and not visited[nx]:
        q.append([nx, c + 1])
        visited[nx] = True

    nx = n - D
    if D != 0 and 0 < nx <= F and not visited[nx]:
        q.append([nx, c + 1])
        visited[nx] = True


if res != -1:
    print(res)

else:
    print("use the stairs")