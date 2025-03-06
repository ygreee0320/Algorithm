N, K = map(int, input().split())

q = [i for i in range(1, N + 1)]
result = []
index = 0

while q:
    index += K - 1
    if len(q) <= index:
        index %= len(q)

    result.append(str(q.pop(index)))

print("<", ", ".join(result), ">", sep="")