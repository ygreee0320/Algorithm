import sys
input = sys.stdin.readline

N, K = map(int, input().split())
words = []
for _ in range(N):
    words.append(input().rstrip())

letters = [False] * 26
for i in ['a', 'n', 't', 'i', 'c']:
    letters[ord(i) - ord('a')] = True

if K < 5:
    print(0)
    exit()

if K >= 26:
    print(N)
    exit()

res = 0


def bt(prev, cnt):
    global res
    if cnt == K - 5:
        tmp = 0
        for w in words:
            flag = False
            for l in w:
                if not letters[ord(l) - ord('a')]:
                    flag = True
                    break
            if not flag:
                tmp += 1
        res = max(res, tmp)
        return

    for i in range(prev, 26):
        if not letters[i]:
            letters[i] = True
            bt(i, cnt + 1)
            letters[i] = False


bt(0, 0)
print(res)