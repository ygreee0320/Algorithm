from collections import deque

N = int(input())

num = deque(i for i in range(1, N + 1))
result = []

while len(num) > 1:
    result.append(num.popleft())
    num.append(num.popleft())

result.append(num[-1])
print(*result)