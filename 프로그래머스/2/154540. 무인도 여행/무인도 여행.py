from collections import deque

def solution(maps):
    answer = []
    
    dx = [-1, 0, 0, 1]
    dy = [0, -1, 1, 0]
    visited = [[False] * len(maps[0]) for _ in range(len(maps))]
    
    def bfs(start_x, start_y):
        q = deque()
        q.append([start_x, start_y])
        cnt = int(maps[start_x][start_y])
        visited[start_x][start_y] = True
        
        while q:
            x, y = q.popleft()
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                    
                if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
                    if maps[nx][ny] != 'X' and not visited[nx][ny]:
                        q.append([nx, ny])
                        visited[nx][ny] = True
                        cnt += int(maps[nx][ny])
                    
        answer.append(cnt)
        
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != 'X' and not visited[i][j]:
                bfs(i, j)
                
    if len(answer) == 0:
        answer.append(-1)
    else:
        answer.sort()
    
    return answer