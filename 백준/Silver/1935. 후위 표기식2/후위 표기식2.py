N = int(input())
cal = list(input())

number = []
for i in range(N):
    number.append(int(input()))

stack = []
for i in cal:
    if 'A' <= i <= 'Z':
        index = ord(i) - 65
        stack.append(number[index])

    else:
        b = stack.pop()
        a = stack.pop()

        if i == '*':
            stack.append(a * b)
        elif i == '/':
            stack.append(a / b)
        elif i == '+':
            stack.append(a + b)
        elif i == '-':
            stack.append(a - b)

print(f"{stack[-1]:.2f}")