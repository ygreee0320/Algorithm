import sys

def dfs(now, value, cnt):
    global res
    if cnt == N:
        if W[now][1]:
            value += W[now][1]
            if res > value:
                res = value
        return

    if value > res:
        return

    for i in range(N):
        if not visited[i] and W[now][i]:
            visited[i] = True
            dfs(i, value + W[now][i], cnt + 1)
            visited[i] = False


N = int(input())
W = []

for _ in range(N):
    data = list(map(int, sys.stdin.readline().split()))
    W.append(data)

res = 1000000 * (N + 1)
visited = [False] * N
visited[1] = True
dfs(1, 0, 1)

print(res)