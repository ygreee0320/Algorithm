INF = 1e9


def backtracking(depth, cnt, combi):
    if depth >= M:
        combis.append(combi.copy())
        return

    for idx in range(cnt, len(chicken)):
        combi.append(idx)
        backtracking(depth+1, idx+1, combi)
        combi.pop()


N, M = map(int, input().split())
chicken = []
house = []

for i in range(N):
    a = list(map(int, input().split()))

    for j, value in enumerate(a):
        if value == 2:
            chicken.append((i, j))
        elif value == 1:
            house.append((i, j))

dist = [[INF] * len(house) for i in range(len(chicken))]

for i in range(len(chicken)):
    for j in range(len(house)):
        dist[i][j] = abs(chicken[i][0] - house[j][0]) + abs(chicken[i][1] - house[j][1])

combis = []
backtracking(0, 0, [])

ans = INF
for cs in combis:
    result = [INF] * len(house)
    for s in cs:
        for h in range(len(house)):
            result[h] = min(result[h], dist[s][h])
    ans = min(ans, sum(result))

print(ans)