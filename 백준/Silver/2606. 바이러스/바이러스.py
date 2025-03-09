from collections import deque

n = int(input())
m = int(input())

com = [[] for i in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    com[a].append(b)
    com[b].append(a)

q = deque()
visited = [False] * (n + 1)
count = 0

q.append(1)
visited[1] = True

while q:
    s = q.popleft()
    for i in com[s]:
        if not visited[i]:
            q.append(i)
            visited[i] = True
            count += 1

print(count)