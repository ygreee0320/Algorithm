N = int(input())

dp = [-1, 0, 1]  # 0: 상근 win, 1: 창영 win
for i in range(3, N + 1):
    if dp[i - 1] == 0 or dp[i - 3] == 0:
        dp.append(1)
    else:
        dp.append(0)

if dp[N] == 0:
    print('SK')
else:
    print('CY')