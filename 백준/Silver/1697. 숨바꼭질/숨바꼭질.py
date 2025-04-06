from collections import deque
import sys
input = sys.stdin.readline
MAX = 10 ** 5


def bfs(start):
    q = deque()
    q.append(start)
    while q:
        x = q.popleft()
        if x == K:
            print(dist[x])
            break
        for i in (x - 1, x + 1, x * 2):
            if 0 <= i <= MAX and not dist[i]:
                dist[i] = dist[x] + 1
                q.append(i)


N, K = map(int, input().split())
dist = [0] * (MAX + 1)

bfs(N)