n, s, p = map(int, input().split())

if n == 0:
    print(1)
    exit()
    
r = list(map(int, input().split()))
result = n + 1

if n == p and r[-1] >= s:
    print(-1)
    exit()

for i in range(n):
    if r[i] <= s:
        result = i + 1
        break

print(result)