n = int(input())

count = [(0, 0), (0, 1), (1, 0)]

for i in range(3, n + 1):
    a = count[i - 1][1] + count[i - 1][0]
    b = count[i - 1][0]
    count.append((a, b))

print(count[n][0] + count[n][1])