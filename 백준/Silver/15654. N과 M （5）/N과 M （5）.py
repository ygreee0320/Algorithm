n, m = map(int, input().split())
nl = list(map(int, input().split()))

nl.sort()
visited = [False] * n
out = []

def backtrack():
    if len(out) == m:
        print(' '.join(map(str, out)))
        return

    for i in range(n):
        if not visited[i]:
            out.append(nl[i])
            visited[i] = True
            backtrack()
            visited[i] = False
            out.pop()

backtrack()