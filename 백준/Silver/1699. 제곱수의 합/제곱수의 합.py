import sys
input = sys.stdin.readline

n = int(input())

dp = [x for x in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, i):
        m = j * j
        if m > i:
            break
        if dp[i - m] + 1 < dp[i]:
            dp[i] = dp[i - m] + 1

print(dp[-1])