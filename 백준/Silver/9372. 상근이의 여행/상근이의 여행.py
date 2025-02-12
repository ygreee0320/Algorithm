t = int(input())

def dfs(node, count):
    visited[node] = True
    for i in graph[node]:
        if not visited[i]:
            count = dfs(i, count + 1)

    return count

for _ in range(t):
    n, m = map(int, input().split()) # n: 나라 수, m: 비행기 수
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())

        graph[a].append(b)
        graph[b].append(a)

    visited = [False] * (n + 1)
    
    count = dfs(1, 0)
    print(count)