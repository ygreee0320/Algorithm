import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

n, m = map(int, input().split())
visited = [False] * n
graph = [[] for _ in range(n)]
res = False

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(start, depth):
    global res
    visited[start] = True

    if depth == 5:
        res = True
        return

    for i in graph[start]:
        if not visited[i]:
            dfs(i, depth + 1)

    visited[start] = False


for i in range(n):
    dfs(i, 1)
    if res:
        break

if res:
    print(1)
else:
    print(0)