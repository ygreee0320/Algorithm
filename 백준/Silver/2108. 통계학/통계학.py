import sys
input = sys.stdin.readline

N = int(input())
nums = []

for _ in range(N):
    a = int(input())
    nums.append(a)

nums.sort()
average = round(sum(nums) / N)
median = nums[N//2]
r = nums[-1] - nums[0]

max_cnt = 1
cnt = 1
modes = [[] for _ in range(N + 1)]
before = nums[0]

for i in range(1, N):
    if nums[i] == before:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
    else:
        modes[cnt].append(before)
        cnt = 1
        before = nums[i]

    if i == N - 1:
        modes[cnt].append(nums[i])

if N == 1:
    mode = nums[0]
else:
    modes[max_cnt].sort()
    if len(modes[max_cnt]) > 1:
        mode = modes[max_cnt][1]
    else:
        mode = modes[max_cnt][0]

print(average)
print(median)
print(mode)
print(r)