k = int(input())
a = input().split()

ans = []
visited = [False] * 10


def check(i, j, op):
    if op == '>':
        return i > j
    else:
        return i < j


def backtracking(depth, s):
    if depth == k + 1:
        ans.append(s)
        return

    for i in range(10):
        if not visited[i]:
            if depth == 0 or check(s[-1], i, a[depth - 1]):
                visited[i] = True
                backtracking(depth + 1, s + [i])
                visited[i] = False


backtracking(0, [])
print(*ans[-1], sep='')
print(*ans[0], sep='')