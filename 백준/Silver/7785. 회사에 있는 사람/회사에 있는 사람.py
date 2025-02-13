import sys

n = int(input())

log = {}

for i in range(n):
    a, b = sys.stdin.readline().split()

    if b == 'enter':
        log[a] = b

    else:
        del log[a]

result = sorted(log, reverse=True)

print('\n'.join(result))