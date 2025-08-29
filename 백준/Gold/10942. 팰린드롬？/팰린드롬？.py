import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
M = int(input())

dp = [[0] * (N + 1) for _ in range(N + 1)]

# 길이 1
for i in range(1, N + 1):
    dp[i][i] = 1  # 항상 팰린드롬

# 길이 2
for i in range(1, N):
    if nums[i - 1] == nums[i]:
        dp[i][i + 1] = 1

# 길이 3 이상
for length in range(3, N + 1):
    for start in range(1, N - length + 2):
        end = start + length - 1
        if nums[start - 1] == nums[end - 1] and dp[start + 1][end - 1]:
            dp[start][end] = 1

for _ in range(M):
    s, e = map(int, input().split())
    print(dp[s][e])