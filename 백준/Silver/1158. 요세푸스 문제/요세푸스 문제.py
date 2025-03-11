N, K = map(int, input().split())

data = [i for i in range(1, N + 1)]
result = []
index = 0

while data:
    index += K - 1

    if index >= len(data):
        index %= len(data)

    a = data.pop(index)
    result.append(str(a))

print("<", ", ".join(result), ">", sep="")