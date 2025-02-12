N = int(input())

visited = [False] * (N + 1)
visited[0] = True
result = []


def backtracking():
    if len(result) == N:
        print(*result)
        return

    for i in range(1, N + 1):
        if not visited[i]:
            result.append(i)
            visited[i] = True
            backtracking()
            result.pop()
            visited[i] = False


backtracking()