from collections import deque

n = int(input())
data = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)

visited = [False] * (n + 1)
ans = [0] * (n + 1)


def bfs(start):
    q = deque()
    visited[start] = True

    for i in data[start]:
        q.append(i)
        ans[i] = start
        visited[i] = True

    while q:
        child = q.popleft()

        for j in data[child]:
            if not visited[j]:
                q.append(j)
                ans[j] = child
                visited[j] = True


bfs(1)
for i in range(2, n + 1):
    print(ans[i])