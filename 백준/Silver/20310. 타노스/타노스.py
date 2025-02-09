s = list(map(int, input()))

result = []

a = s.count(0) // 2
b = s.count(1) // 2

for i in range(b):
    s.remove(1)

s.reverse()
for j in range(a):
    s.remove(0)
s.reverse()

for k in s:
    print(k, end="")