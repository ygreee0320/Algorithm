import heapq
INF = int(1e9)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue

        for i in bus[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


N = int(input())
M = int(input())

bus = [[] for i in range(N+1)]
for _ in range(M):
    a, b, c = map(int, input().split())
    bus[a].append([b, c])

start, end = map(int, input().split())
distance = [INF] * (N+1)
distance[start] = 0
dijkstra(start)
print(distance[end])