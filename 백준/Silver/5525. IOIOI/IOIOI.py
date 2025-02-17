import sys

N = int(input())
M = int(input())
S = sys.stdin.readline().rstrip()

PN = 'IOI' + 'OI' * (N - 1)

count = 0
for i in range(len(S)):
    if S[i:i+len(PN)] == PN:
        count += 1

print(count)