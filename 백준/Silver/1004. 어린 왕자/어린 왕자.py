T = int(input())

for _ in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    data = []
    result = 0

    for i in range(n):
        cx, cy, r = map(int, input().split())
        data.append((cx, cy, r))

    for i in data:
        d1 = (x1 - i[0]) ** 2 + (y1 - i[1]) ** 2
        d2 = (x2 - i[0]) ** 2 + (y2 - i[1]) ** 2

        if d1 < (i[2] ** 2) < d2 or d2 < (i[2] ** 2) < d1:
            result += 1

    print(result)