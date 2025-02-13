N = int(input())

count = 0

for i in range(1, N + 1):
    if i < 100:
        count += 1
    elif i < 1000:
        a = str(i)
        if (int(a[0]) - int(a[1])) == (int(a[1]) - int(a[2])):
            count += 1

print(count)