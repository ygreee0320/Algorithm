import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[False] * (N + 1) for _ in range(N + 1)]
visited1 = [False] * (N + 1)
visited2 = [False] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True


def dfs(v):
    visited1[v] = True
    print(v, end=' ')

    for i in range(1, N + 1):
        if not visited1[i] and graph[v][i]:
            dfs(i)


def bfs():
    q = deque()
    q.append(V)
    visited2[V] = True
    res = [V]

    while q:
        n = q.popleft()

        for i in range(1, N + 1):
            if not visited2[i] and graph[n][i]:
                res.append(i)
                q.append(i)
                visited2[i] = True

    print(*res)

dfs(V)
print()
bfs()