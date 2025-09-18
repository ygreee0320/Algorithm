import sys
input = sys.stdin.readline
vowel = ['a', 'e', 'i', 'o', 'u']

l, c = map(int, input().split())
data = input().split()
data.sort()
res = []


def check(arr):
    cnt_v, cnt_c = 0, 0

    for i in arr:
        if i in vowel:
            cnt_v += 1
        else:
            cnt_c += 1

    if cnt_v >= 1 and cnt_c >= 2:
        return True
    else:
        return False


def backtracking(start):
    if len(res) == l:
        if check(res):
            print("".join(res))
        return

    for i in range(start, c):
        res.append(data[i])
        backtracking(i + 1)
        res.pop()


backtracking(0)