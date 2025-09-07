import sys
input = sys.stdin.readline

def solution(numbers):
    numbers.sort()

    for i in range(len(numbers) - 1):
        if numbers[i] in numbers[i + 1][0:len(numbers[i])]:
            print("NO")
            return False
    print("YES")


t = int(input())

for _ in range(t):
    n = int(input())
    numbers = []

    for _ in range(n):
        numbers.append(input().strip())

    solution(numbers)