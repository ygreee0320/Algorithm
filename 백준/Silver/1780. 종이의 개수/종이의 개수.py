import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]

res = []

def divide(x, y, n):
    t = data[x][y]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if t != data[i][j]:
                for a in range(3):
                    for b in range(3):
                        divide(x + (n//3)*a, y + (n//3)*b, n//3)
                return

    if t == 1:
        res.append(1)

    elif t == -1:
        res.append(-1)

    else:
        res.append(0)

divide(0, 0, n)
print(res.count(-1), res.count(0), res.count(1), sep='\n')