N = int(input())
X = list(map(int, input().split()))

sorted_unique_X = sorted(set(X))

dic = {sorted_unique_X[i]: i for i in range(len(sorted_unique_X))}

for i in X:
    print(dic[i], end= ' ')