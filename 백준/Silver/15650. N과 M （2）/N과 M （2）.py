N, M = map(int, input().split())

result = []

def backtracking(start):
    if len(result) == M:
        print(*result)
        return

    for i in range(start, N + 1):
        result.append(i)
        backtracking(i + 1)
        result.pop()

backtracking(1)