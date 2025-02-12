import sys

N, M = map(int, input().split())

l_set = set(sys.stdin.readline().rstrip() for _ in range(N))
result = []

for _ in range(M):
    a = sys.stdin.readline().rstrip()

    if a in l_set:
        result.append(a)

result.sort()
print(len(result))
print('\n'.join(result))