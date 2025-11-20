import sys
input = sys.stdin.readline
INF = 2 ** 31

N = int(input())
arr = [tuple(map(int, input().split())) for _ in range(N)]
dp = [[INF] * N for _ in range(N)]

for i in range(N):
    dp[i][i] = 0

for i in range(1, N):
    for j in range(N - i):
        for k in range(j, j + i):
            tmp = dp[j][k] + dp[k + 1][j + i] + (arr[j][0] * arr[k][1] * arr[j + i][1])
            dp[j][j + i] = min(dp[j][j + i], tmp)

print(dp[0][-1])