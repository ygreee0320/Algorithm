import sys
input = sys.stdin.readline

alpa = [0] * 26
for _ in range(int(input())):
    a = list(input().rstrip())
    a.reverse()
    t = 1

    for i in a:
        alpa[ord(i) - 65] += t
        t *= 10

alpa.sort(reverse=True)
n = 9
ans = 0
for i in alpa:
    if i == 0:
        break
    ans += i * n
    n -= 1

print(ans)