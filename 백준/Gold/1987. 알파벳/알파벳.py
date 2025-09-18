import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

r, c = map(int, input().split())
board = [input() for _ in range(r)]
max_length = 0
visited = [False] * 26


def dfs(x, y, length):
    global max_length
    max_length = max(max_length, length)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < c and 0 <= ny < r:
            idx = ord(board[ny][nx]) - ord('A')

            if not visited[idx]:
                visited[idx] = True
                dfs(nx, ny, length + 1)
                visited[idx] = False


start_idx = ord(board[0][0]) - ord('A')
visited[start_idx] = True
dfs(0, 0, 1)
print(max_length)