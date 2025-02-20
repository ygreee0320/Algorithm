N = int(input())
data = []

for i in range(N):
    data.append(list(map(int, input().split())))

visited = [False for _ in range(N)]
INF = 2147000000
res = INF

def backtracking(start, idx):
    global res
    if start == N//2:  # 선수 중 절반을 방문했다면 (남은 절반은 다른 팀)
        A = 0
        B = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:  # 방문한 팀: A
                    A += data[i][j]
                elif not visited[i] and not visited[j]:  # 방문하지 않은 팀: B
                    B += data[i][j]
        res = min(res, abs(A - B))

    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            backtracking(start + 1, i + 1)
            visited[i] = False

backtracking(0, 0)
print(res)