import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(set(map(int, input().split())))
nums.sort()

ans = []

def backtracking(start):
    if len(ans) == m:
        print(*ans)
        return

    for i in range(start, len(nums)):
        ans.append(nums[i])
        backtracking(i)
        ans.pop()


backtracking(0)