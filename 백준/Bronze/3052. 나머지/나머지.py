rest = []

for i in range(10):
    n = int(input())

    if (n % 42) in rest:
        continue
    rest.append(n % 42)

print(len(rest))