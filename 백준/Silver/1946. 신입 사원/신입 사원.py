import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    rank = []
    selected = [False] * N
    standard1, standard2 = N, N
    res = 0

    for i in range(N):
        a, b = map(int, input().split())
        rank.append((a, b, i))

    rank.sort(key=lambda x: x[0])

    for r1, r2, idx in rank:
        if not selected[idx]:
            if r1 < standard1 or r2 < standard2:
                selected[idx] = True
                standard1 = r1
                standard2 = r2
                res += 1

    print(res)