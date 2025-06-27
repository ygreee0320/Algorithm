n = int(input())
tree = [[] for _ in range(n)]

for i in range(n):
    a = list(map(int, input().split()))
    tree[i] = a

dp = [[0] * (i + 1) for i in range(n)]
dp[0][0] = tree[0][0]

for j in range(1, n):
    for k in range(j + 1):
        if k == 0:
            dp[j][k] = dp[j-1][k] + tree[j][k]
        elif k == j:
            dp[j][k] = dp[j-1][k-1] + tree[j][k]
        else:
            dp[j][k] = max(dp[j-1][k-1], dp[j-1][k]) + tree[j][k]

print(max(dp[-1]))