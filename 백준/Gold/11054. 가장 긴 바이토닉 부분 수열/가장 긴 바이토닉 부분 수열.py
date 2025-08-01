N = int(input())
A = list(map(int, input().split()))
reverse_A = A[::-1]

increase = [1] * N
decrease = [1] * N

for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            increase[i] = max(increase[i], increase[j] + 1)
        if reverse_A[i] > reverse_A[j]:
            decrease[i] = max(decrease[i], decrease[j] + 1)

result = [0] * N
for i in range(N):
    result[i] = increase[i] + decrease[N-i-1] - 1

print(max(result))