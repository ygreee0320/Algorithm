def hanoi_top(k, start, target, assi):
    if k == 1:
        print(start, target)
        return
    hanoi_top(k - 1, start, assi, target)
    print(start, target)
    hanoi_top(k - 1, assi, target, start)


k = int(input())
print(2**k - 1)
hanoi_top(k, 1, 3, 2)