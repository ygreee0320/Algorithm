import sys

N = int(input())
books = []

for _ in range(N):
    books.append(sys.stdin.readline().rstrip())

b_set = set(books)
m = 0
result = []

for i in b_set:
    c = books.count(i)
    if c > m:
        while result:
            result.pop()
        result.append(i)
        m = c
    elif c == m:
        result.append(i)
        m = c

result.sort()
print(result[0])