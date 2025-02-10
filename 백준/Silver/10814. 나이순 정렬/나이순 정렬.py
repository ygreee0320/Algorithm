n = int(input())
member = []

for i in range(n):
    a, b = input().split()
    a = int(a)
    member.append((a, b))

member.sort(key=lambda x: x[0])

for i in member:
    print(i[0], i[1])