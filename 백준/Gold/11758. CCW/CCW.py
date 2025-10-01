p = []
for _ in range(3):
    x, y = map(int, input().split())
    p.append((x, y))


def ccw(x1, y1, x2, y2, x3, y3):
    return x1*y2 + x2*y3 + x3*y1 - x2*y1 - x3*y2 - x1*y3


l = ccw(p[0][0], p[0][1], p[1][0], p[1][1], p[2][0], p[2][1])

if l > 0:
    print(1)
elif l < 0:
    print(-1)
else:
    print(0)