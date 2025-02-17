import sys

N = int(input())
M = int(input())
S = sys.stdin.readline().rstrip()

PN = 'IOI' + 'OI' * (N - 1)

result, i, count = 0, 0, 0  # 최종 결과, 찾는 중인 인덱스, 101 연속 개수

while i < (M - 1):
    if S[i:i+3] == 'IOI':
        count += 1
        i += 2
        if count == N:
            result += 1
            count -= 1
    else:
        i += 1
        count = 0

print(result)