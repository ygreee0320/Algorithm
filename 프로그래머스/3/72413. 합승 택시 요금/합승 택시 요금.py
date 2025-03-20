import heapq
INF = int(1e9)

def dijkstra(start, distance, graph):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
            
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

def solution(n, s, a, b, fares):
    answer = INF
    graph = [[] for i in range(n + 1)]
    
    dist_start = [INF] * (n + 1)
    dist_a = [INF] * (n + 1)
    dist_b = [INF] * (n + 1)
    
    for i in fares:
        graph[i[0]].append((i[1], i[2]))
        graph[i[1]].append((i[0], i[2]))
    
    dist_start = dijkstra(s, dist_start, graph)
    dist_a = dijkstra(a, dist_a, graph)
    dist_b = dijkstra(b, dist_b, graph)
    
    for i in range(1, n + 1):
        cost = dist_start[i] + dist_a[i] + dist_b[i]
        if cost < answer:
            answer = cost
    
    return answer