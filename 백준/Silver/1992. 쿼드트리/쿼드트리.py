import sys
input = sys.stdin.readline

N = int(input())
data = []

for _ in range(N):
    data.append(list(map(int, input().rstrip())))


def quardTree(start_x, start_y, n):
    c = data[start_x][start_y]

    if n == 1:
        print(c, end='')
        return

    for i in range(start_x, start_x + n):
        for j in range(start_y, start_y + n):
            if data[i][j] != c:
                dn = n // 2
                print("(", end='')
                quardTree(start_x, start_y, dn)
                quardTree(start_x, start_y + dn, dn)
                quardTree(start_x + dn, start_y, dn)
                quardTree(start_x + dn, start_y + dn, dn)
                print(")", end='')
                return
    print(c, end='')


quardTree(0, 0, N)