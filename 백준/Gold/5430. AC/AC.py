import ast
from collections import deque
import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    p = input().strip()
    n = int(input())
    q = deque(ast.literal_eval(input()))

    rev = False
    error = False

    for i in p:
        if i == "R":
            rev = not rev
        elif i == "D":
            if len(q) != 0 and not rev:
                q.popleft()
            elif len(q) != 0 and rev:
                q.pop()
            else:
                print("error")
                error = True
                break

    if not error:
        if rev:
            q.reverse()
        print(f"[{','.join(map(str, q))}]")