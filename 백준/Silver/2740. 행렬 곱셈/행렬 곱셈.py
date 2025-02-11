n, m = map(int, input().split())
a = []

for i in range(n):
    a.append(list(map(int, input().split())))

m, k = map(int, input().split())
b = []

for i in range(m):
    b.append(list(map(int, input().split())))

result = [[0 for i in range(k)] for j in range(n)]

for i in range(n):
    for p in range(k):
        mul = 0

        for j in range(m):
            mul += a[i][j] * b[j][p]

        result[i][p] = mul

for i in range(n):
    for j in range(k):
        print(result[i][j], end=' ')
    print()