import sys
sys.setrecursionlimit(10**4)

T = int(input())

def dfs(index):
    if not visited[index]:
        visited[index] = True
        dfs(data[index])

for _ in range(T):
    N = int(input())
    data = [0] + list(map(int, input().split()))

    visited = [False] * (N + 1)
    count = 0

    for i in range(1, N + 1):
        if not visited[i]:
            dfs(data[i])
            count += 1

    print(count)