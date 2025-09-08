h, w = map(int, input().split())
b = list(map(int, input().split()))

left_max = [0] * w
right_max = [0] * w

left_max[0] = b[0]
for i in range(1, w):
    left_max[i] = max(left_max[i - 1], b[i])

right_max[-1] = b[-1]
for i in range(w - 2, -1, -1):
    right_max[i] = max(right_max[i + 1], b[i])

ans = 0
for i in range(w):
    ans += max(0, min(left_max[i], right_max[i]) - b[i])

print(ans)