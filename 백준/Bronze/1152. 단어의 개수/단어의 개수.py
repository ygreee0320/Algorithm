import sys
s = sys.stdin.readline().strip()

if not s:
    print(0)
else:
    print(s.count(" ") + 1)