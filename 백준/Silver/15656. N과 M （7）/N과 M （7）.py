N, M = map(int, input().split())
num = list(map(int, input().split()))

num.sort()
result = []

def backtracking():
    if len(result) == M:
        print(*result)
        return

    for i in num:
        result.append(i)
        backtracking()
        result.pop()


backtracking()