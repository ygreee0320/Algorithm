N = int(input())

rope = [int(input()) for _ in range(N)]
rope.sort(reverse=True)

result = 0

for i in range(N):
    result = max(result, rope[i] * (i + 1))

print(result)