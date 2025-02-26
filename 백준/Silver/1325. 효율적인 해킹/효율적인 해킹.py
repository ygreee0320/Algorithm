from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

data = [[] for i in range(N + 1)]
max_cnt = 0
result = []

for _ in range(M):
    a, b = map(int, input().split())
    data[b].append(a)

for i in range(1, N + 1):
    q = deque()
    visited = [False] * (N + 1)
    count = 0

    q.append(i)
    visited[i] = True

    while q:
        p = q.popleft()

        for b in data[p]:
            if not visited[b]:
                q.append(b)
                visited[b] = True
                count += 1

    if count == max_cnt:
        result.append(i)
    elif count > max_cnt:
        result.clear()
        max_cnt = count
        result.append(i)

result.sort()
print(*result)