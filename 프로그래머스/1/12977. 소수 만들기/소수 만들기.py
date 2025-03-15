answer = 0

def dfs(s, v, nums):
    global answer
    
    if len(s) == 3:
        n = 0
        for i in s:
            n += nums[i]
            
        for i in range(2, n):
            if n % i == 0:
                break
        else:
            answer += 1
        return
    
    for i in range(s[-1] + 1, len(nums)):
        if not v[i]:
            s.append(i)
            v[i] = True
            dfs(s, v, nums)
            s.pop()
            v[i] = False

def solution(nums):
    global answer
    visited = [False] * (len(nums) + 1)
    selected = []
    visited[0] = True
    
    for i in range(len(nums)):
        selected.append(i)
        dfs(selected, visited, nums)
        selected.pop()

    return answer