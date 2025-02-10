from collections import deque
t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    q = deque(list(map(int, input().split())))
    result = 0

    while q:
        first = max(q)
        pop = q.popleft()
        m -= 1

        if pop == first:
            result += 1
            if m < 0:
                print(result)
                break
        else:
            q.append(pop)
            if m < 0:
                m = len(q) - 1