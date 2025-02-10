n = int(input())

result = 0
digit = 1
start = 1

while n >= start:
    end = min(n, start * 10 - 1)
    count = end - start + 1
    result += count * digit
    digit += 1
    start *= 10

print(result)