import sys
sys.setrecursionlimit(1000000)

def bfs(start, distance):
    for next, next_d in tree[start]:
        if visited[next] == -1:
            visited[next] = next_d + distance
            bfs(next, visited[next])

n = int(input())
tree = [[] for i in range(n + 1)]

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    tree[a].append([b, c])
    tree[b].append([a, c])

visited = [-1] * (n + 1)
visited[1] = 0
bfs(1, 0)

start = visited.index(max(visited))
visited = [-1] * (n + 1)
visited[start] = 0
bfs(start, 0)

print(max(visited))