N, M = map(int, input().split())

result = []


def dfs(start):
    if len(result) == M:
        print(*result)
        return

    for j in range(start, N + 1):
        result.append(j)
        dfs(j)
        result.pop()


dfs(1)