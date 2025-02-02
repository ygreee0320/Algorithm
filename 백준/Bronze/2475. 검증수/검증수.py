code = list(map(int, input().split()))
s = 0

for i in code:
    s = s + i*i

print(s%10)