from collections import deque
MAX = 100001

n, k = map(int, input().split())
dist = [-1] * MAX
cnt = [0] * MAX

q = deque()
q.append(n)
dist[n] = 0
cnt[n] = 1

while q:
    s = q.popleft()

    for i in (s - 1, s + 1, 2 * s):
        if 0 <= i < MAX:
            if dist[i] == -1:
                dist[i] = dist[s] + 1
                cnt[i] = cnt[s]
                q.append(i)

            elif dist[i] == dist[s] + 1:
                cnt[i] += cnt[s]

print(dist[k])
print(cnt[k])