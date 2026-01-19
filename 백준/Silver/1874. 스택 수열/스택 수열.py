import sys
input = sys.stdin.readline

n = int(input())
stack = []
current = 1
res = []
possible = True

for _ in range(n):
    a = int(input())

    while current <= a:
        stack.append(current)
        res.append("+")
        current += 1

    if stack[-1] == a:
        stack.pop()
        res.append("-")
    else:
        possible = False
        break

if possible:
    for op in res:
        print(op)
else:
    print("NO")