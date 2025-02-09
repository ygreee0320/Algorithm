import sys
from collections import deque

n = int(input())
a = list(map(int, sys.stdin.readline().split()))
a.reverse()

dq = deque()
for i in range(n):
    if a[i] == 1:
        dq.appendleft(i + 1)
    elif a[i] == 2:
        dq.insert(1, i + 1)
    elif a[i] == 3:
        dq.append(i + 1)

for i in dq:
    print(i, end=" ")