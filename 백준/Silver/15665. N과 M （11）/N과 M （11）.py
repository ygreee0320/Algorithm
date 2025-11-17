N, M = map(int, input().split())
data = list(map(int, input().split()))

data = sorted(list(set(data)))
ans = []


def backtracking(depth):
    if depth == M:
        print(*ans)
        return

    for i in range(len(data)):
        ans.append(data[i])
        backtracking(depth + 1)
        ans.pop()


for i in data:
    ans.append(i)
    backtracking(1)
    ans.pop()