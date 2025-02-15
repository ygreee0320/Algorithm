from collections import deque

N, M = map(int, input().split())

queue = deque([i for i in range(1, N + 1)])
order = list(map(int, input().split()))

count = 0

for i in order:
    idx = queue.index(i)

    if idx == 0:
        queue.popleft()
        continue

    elif idx > len(queue) // 2:
        while queue[0] != i:
            a = queue.pop()
            queue.appendleft(a)
            count += 1
    else:
        while queue[0] != i:
            a = queue.popleft()
            queue.append(a)
            count += 1

    queue.popleft()

print(count)