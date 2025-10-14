import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    a, b = map(int, input().split())

    visited = [False] * 10001
    q = deque()
    q.append([a, ''])
    visited[a] = True

    while q:
        n, command = q.popleft()

        if n == b:
            print(command)
            break

        d = n * 2 % 10000
        if not visited[d]:
            visited[d] = True
            q.append([d, command + 'D'])

        s = (n - 1) % 10000
        if not visited[s]:
            visited[s] = True
            q.append([s, command + 'S'])

        l = n // 1000 + (n % 1000) * 10
        if not visited[l]:
            visited[l] = True
            q.append([l, command + 'L'])

        r = n // 10 + (n % 10) * 1000
        if not visited[r]:
            visited[r] = True
            q.append([r, command + 'R'])