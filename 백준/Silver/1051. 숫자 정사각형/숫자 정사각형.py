N, M = map(int, input().split())
data = []

for i in range(N):
    data.append(list(map(int, list(input()))))

size = min(N, M)
result = 0

for i in range(size + 1, 1, -1):
    n_end_index = i - 1
    m_end_index = i - 1

    for j in range(n_end_index, N):
        for k in range(m_end_index, M):
            if data[j][k] == data[j][k-i+1] and data[j-i+1][k] == data[j-i+1][k-i+1] and data[j][k] == data[j-i+1][k]:
                print(i**2)
                exit()

print(1)