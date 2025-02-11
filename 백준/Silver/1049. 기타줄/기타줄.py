n, m = map(int, input().split())
ml = []

for i in range(m):
    a, b = map(int, input().split())
    ml.append((a, b))

p = n // 6
np = n % 6

p_min_cost = min(ml, key=lambda x: x[0])[0]
np_min_cost = min(ml, key=lambda x: x[1])[1]

if np_min_cost * 6 < p_min_cost:
    print(n * np_min_cost)
elif np_min_cost * np > p_min_cost:
    print((p + 1) * p_min_cost)
else:
    print((p * p_min_cost) + (np * np_min_cost))