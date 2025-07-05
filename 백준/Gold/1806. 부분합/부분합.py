import sys
input = sys.stdin.readline
INF = 1e9

N, S = map(int, input().split())
sequence = list(map(int, input().split()))

left, right = 0, 0
sum = 0
min_length = INF

while True:
    if sum >= S:
        min_length = min(min_length, right - left)
        sum -= sequence[left]
        left += 1

    elif right == N:
        break

    else:
        sum += sequence[right]
        right += 1

if min_length == INF:
    print(0)
else:
    print(min_length)