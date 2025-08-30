import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, M, X = map(int, input().split())
village = [[] for i in range(N + 1)]

for _ in range(M):
    a, b, t = map(int, input().split())
    village[a].append((b, t))

def dijkstra(start):
    q = []
    distance = [INF] * (N + 1)

    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue
        for i in village[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance

result = 0
for i in range(1, N + 1):
    go = dijkstra(i)
    back = dijkstra(X)
    result = max(result, go[X] + back[i])

print(result)