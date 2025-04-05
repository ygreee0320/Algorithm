import sys
input = sys.stdin.readline

N = int(input())
data = []
for _ in range(N):
    r, g, b = map(int, input().split())
    data.append([r, g, b])

dp = [data[0]]

for i in range(1, N):
    next_r = min(dp[i - 1][1], dp[i - 1][2]) + data[i][0]
    next_g = min(dp[i - 1][0], dp[i - 1][2]) + data[i][1]
    next_b = min(dp[i - 1][0], dp[i - 1][1]) + data[i][2]
    dp.append([next_r, next_g, next_b])

print(min(dp[-1]))