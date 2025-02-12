n = int(input())
data = [0]

for _ in range(n):
    data.append(int(input()))

if n == 1:
    print(data[n])
    exit()

score = [0, data[1], data[1] + data[2]]

for i in range(3, n + 1):
    new = max(score[i - 3] + data[i - 1], score[i - 2]) + data[i]
    score.append(new)

print(score[n])