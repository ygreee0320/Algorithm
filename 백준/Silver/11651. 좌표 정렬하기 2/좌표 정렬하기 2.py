N = int(input())

data = []

for i in range(N):
    x, y = map(int, input().split())
    data.append((x, y))

data.sort(key=lambda x: (x[1], x[0]))

for i in data:
    print(i[0], i[1])