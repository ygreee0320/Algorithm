import sys
input = sys.stdin.readline

def check_queen(q):
    for i in range(q):
        if row[i] == row[q] or abs(row[q] - row[i]) == abs(q - i):
            return False
    return True


def backtracking(q):
    global cnt
    if q == N:
        cnt += 1
        return

    for i in range(N):
        row[q] = i
        if check_queen(q):
            backtracking(q + 1)


N = int(input())
cnt = 0
row = [-1] * N

backtracking(0)
print(cnt)