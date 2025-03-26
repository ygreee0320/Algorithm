import sys, heapq
input = sys.stdin.readline

N = int(input())
h = []

for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(h, (abs(x), x))
    else:
        if h:
            print(heapq.heappop(h)[1])
        else:
            print(0)