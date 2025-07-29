import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

left_idx = 0
right_idx = N - 1
ans = abs(data[left_idx] + data[right_idx])
ans_left = data[left_idx]
ans_right = data[right_idx]

while left_idx < right_idx:
    s = data[left_idx] + data[right_idx]
    if abs(s) < ans:
        ans_left = data[left_idx]
        ans_right = data[right_idx]
        ans = abs(s)

        if ans == 0:
            break

    elif s > 0:
        right_idx -= 1
    else:
        left_idx += 1

print(ans_left, ans_right)