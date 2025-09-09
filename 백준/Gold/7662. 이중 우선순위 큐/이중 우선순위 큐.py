import heapq
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    k = int(input())
    visited = [False] * k
    maxQ, minQ = [], []

    for i in range(k):
        operation, n = input().split()
        n = int(n)
        if operation == 'I':
            heapq.heappush(minQ, (n, i))
            heapq.heappush(maxQ, (-n, i))
            visited[i] = True

        elif n == 1:
            while maxQ and not visited[maxQ[0][1]]:
                heapq.heappop(maxQ)
            if maxQ:
                visited[maxQ[0][1]] = False
                heapq.heappop(maxQ)

        else:
            while minQ and not visited[minQ[0][1]]:
                heapq.heappop(minQ)
            if minQ:
                visited[minQ[0][1]] = False
                heapq.heappop(minQ)

    while minQ and not visited[minQ[0][1]]:
        heapq.heappop(minQ)
    while maxQ and not visited[maxQ[0][1]]:
        heapq.heappop(maxQ)

    if maxQ and minQ:
        print(-maxQ[0][0], minQ[0][0])
    else:
        print("EMPTY")