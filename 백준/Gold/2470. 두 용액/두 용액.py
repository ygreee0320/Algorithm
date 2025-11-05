import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
data.sort()

left = 0
right = n - 1
s = abs(data[left] + data[right])

ans_left = data[left]
ans_right = data[right]

while left < right:
    c = data[left] + data[right]

    if abs(c) < s:
        ans_left = data[left]
        ans_right = data[right]
        s = abs(c)

        if s == 0:
            break

    elif c < 0:
        left += 1

    else:
        right -= 1

print(ans_left, ans_right)