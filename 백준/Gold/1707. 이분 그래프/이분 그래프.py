from collections import deque
import sys
input = sys.stdin.readline


def bfs(start, group_type):
    q = deque([start])
    visited[start] = group_type

    while q:
        n = q.popleft()

        for link_node in graph[n]:
            if not visited[link_node]:
                q.append(link_node)
                visited[link_node] = - visited[n]
            elif visited[link_node] == visited[n]:
                return False
            
    return True


k = int(input())

for _ in range(k):
    v, e = map(int, input().split())
    graph = [[] for _ in range(v + 1)]
    visited = [False] * (v + 1)

    for _ in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1, v + 1):
        if not visited[i]:
            res = bfs(i, 1)

            if not res:
                print("NO")
                break
    else:
        print("YES")