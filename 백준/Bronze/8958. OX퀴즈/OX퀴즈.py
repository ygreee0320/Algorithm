t = int(input())

for i in range(t):
    r = input()
    s = 0

    split = list(r.split('X'))
    for j in split:
        c = j.count('O')
        for k in range(1, c + 1):
            s += k
    print(s)