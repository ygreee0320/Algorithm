import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))

result = 0
sum_list = deque()

for i in range(N):
    if sum(sum_list) + data[i] == M:
        result += 1
        if sum_list:
            sum_list.popleft()

    elif sum(sum_list) + data[i] > M:
        while sum(sum_list) + data[i] > M and sum_list:
            sum_list.popleft()
        if sum(sum_list) + data[i] == M:
            result += 1

    sum_list.append(data[i])

print(result)