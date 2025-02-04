h, m = map(int, input().split())

t = 60 * h + m - 45

if (t // 60) < 0:
    print(24 + (t // 60), t % 60)
else:
    print(t // 60, t % 60)