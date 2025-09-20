n = int(input())
board = [[' ' for _ in range(n)] for _ in range(n)]


def divide(x, y, size):
    if size == 1:
        board[x][y] = '*'
        return

    div = size // 3
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue
            divide(x + i * div, y + j * div, div)


divide(0, 0, n)
for row in board:
    print(''.join(row))