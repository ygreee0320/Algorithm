import sys
from itertools import combinations
input = sys.stdin.readline

N = int(input())
result = []

for i in range(1, 11):
    for j in combinations(range(10), i):
        comb_list = sorted(list(j), reverse=True)
        num = int("".join(map(str, comb_list)))
        result.append(num)

result.sort()

if N < len(result):
    print(result[N])
else:
    print(-1)