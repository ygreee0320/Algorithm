def find_empty():
    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                return i, j
    return None, None

def valid(col, row, val):
    for i in range(9):
        if board[col][i] == val: return False
        if board[i][row] == val: return False
    box_col = col//3
    box_row = row//3

    for i in range(3):
        for j in range(3):
            if board[box_col*3 + i][box_row*3 + j] == val:
                return False
    return True

def solution():
    col, row = find_empty()
    if col is None:
        return True
    else:
        for i in range(1, 10):
            if valid(col, row, i):
                board[col][row] = i
                if solution():
                    return True
                board[col][row] = 0
        return False

board = [list(map(int, input())) for _ in range(9)]
solution()
for i in range(9):
    print(*board[i], sep='')