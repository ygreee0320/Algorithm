a1, a2 = map(int, input().split())
c = int(input())
n0 = int(input())

for i in range(n0, 101):
    fn = a1 * i + a2
    gn = c * i
    if fn > gn:
        print(0)
        exit()

print(1)