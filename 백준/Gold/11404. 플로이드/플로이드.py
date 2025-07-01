INF = int(1e9)

n = int(input())
m = int(input())
bus = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            bus[i][j] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    bus[a][b] = min(bus[a][b], c)

for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            bus[a][b] = min(bus[a][b], bus[a][k] + bus[k][b])

for a in range(1, n + 1):
    for b in range(1, n + 1):
        if bus[a][b] == INF:
            print(0, end=" ")
        else:
            print(bus[a][b], end=" ")
    print()