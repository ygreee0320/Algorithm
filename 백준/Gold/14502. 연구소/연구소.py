from collections import deque
import sys
import copy
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs():
    q = deque()
    tmp_graph = copy.deepcopy(graph)

    for i in range(n):
        for j in range(m):
            if tmp_graph[i][j] == 2:
                q.append((i, j))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if tmp_graph[nx][ny] == 0:
                    tmp_graph[nx][ny] = 2
                    q.append((nx, ny))

    global res
    cnt = 0

    for i in range(n):
        cnt += tmp_graph[i].count(0)

    res = max(res, cnt)


def makeWall(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                makeWall(cnt + 1)
                graph[i][j] = 0


for _ in range(n):
    graph.append(list(map(int, input().split())))

res = 0
makeWall(0)
print(res)