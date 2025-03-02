import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(node):
    visited[node] = True
    for i in data[node]:
        if not visited[i]:
            dfs(i)


N, M = map(int, input().split())
data = [[] for i in range(N + 1)]

for _ in range(M):
    u, v = map(int, input().split())
    data[u].append(v)
    data[v].append(u)

visited = [False] * (N + 1)
count = 0

for i in range(1, N + 1):
    if not visited[i]:
        dfs(i)
        count += 1

print(count)