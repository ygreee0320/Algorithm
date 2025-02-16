import sys

result = []
visited = [False] * 50

def backtracking(start, numbers):
    if len(result) == 6:
        print(*result)
        return

    for i in range(start, len(numbers)):
        if visited[i]:
            continue

        result.append(numbers[i])
        visited[i] = True
        backtracking(i, numbers)
        result.pop()
        visited[i] = False


while True:
    data = list(map(int, sys.stdin.readline().split()))

    k = data[0]
    S = data[1:]

    if k == 0 and len(S) == 0:
        exit()

    backtracking(0, S)
    print()