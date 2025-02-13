S = int(input())
count = 0

for i in range(1, S + 1):
    if (S - i) < 0:
        print(count)
        exit()
    else:
        S -= i
        count += 1

print(count)