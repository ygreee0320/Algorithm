import sys
input = sys.stdin.readline

left_s = list(input().rstrip())
right_s = []
M = int(input().rstrip())

for _ in range(M):
    command = input().split()
    if command[0] == 'L' and left_s:
        right_s.append(left_s.pop())
    elif command[0] == 'D' and right_s:
        left_s.append(right_s.pop())
    elif command[0] == 'B' and left_s:
        left_s.pop()
    elif command[0] == 'P':
        left_s.append(command[1])

print(''.join(left_s + right_s[::-1]))