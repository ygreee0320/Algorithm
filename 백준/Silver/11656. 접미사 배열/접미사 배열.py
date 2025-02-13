S = input()

result = []

for i in range(1, len(S) + 1):
    result.append(S[-i:])

result.sort()
print('\n'.join(result))