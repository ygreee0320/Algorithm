import sys
input = sys.stdin.readline

N, S = map(int, input().split())
data = list(map(int, input().split()))
result = 0
selected = []


def backtrack(start):
    global result

    if sum(selected) == S and len(selected) > 0:
        result += 1

    for i in range(start, N):
        selected.append(data[i])
        backtrack(i + 1)
        selected.pop()


backtrack(0)
print(result)