from collections import deque
MAX = 10 ** 5

def bfs(start):
    q = deque()
    q.append(start)
    time[start] = 0
    while q:
        x = q.popleft()
        if x == K:
            print(time[x])
            break
        for i in (2 * x, x - 1, x + 1):
            if 0 <= i <= MAX and time[i] == -1 and i == 2 * x:
                q.append(i)
                time[i] = time[x]
            elif 0 <= i <= MAX and time[i] == -1 and i != 2 * x:
                q.append(i)
                time[i] = time[x] + 1


N, K = map(int, input().split())
time = [-1] * (MAX + 1)

bfs(N)