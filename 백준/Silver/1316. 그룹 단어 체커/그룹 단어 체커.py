import sys

N = int(input())
result = 0

for i in range(N):
    w = sys.stdin.readline().rstrip()

    if len(w) == 1:
        result += 1
    else:
        a = [w[0]]

        for j in range(1, len(w)):
            if w[j] != w[j - 1] and w[j] in a:
                break

            elif j == len(w) - 1:
                result += 1

            elif w[j] != w[j - 1]:
                a.append(w[j - 1])

print(result)