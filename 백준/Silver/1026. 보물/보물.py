N = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
sb = b
sb.sort()

rank_list = [0] * N
rank = 0

for i in range(len(b)):
    if b[i] == sb[rank]:
        rank_list[i] = rank
        rank += 1

result = 0

for i in rank_list:
    result += a[i] * b[N - 1 - i]

print(result)