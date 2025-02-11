n = int(input())
count = [1, 1]

for i in range(2, n + 1):
    a = count[i - 1]
    b = count[i - 2]

    count.append((a + b) % 15746)

print(count[n])