import sys
input = sys.stdin.readline

N, M = map(int, input().split())
edges = []
for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

edges.sort(key=lambda x: x[2])
parent = [i for i in range(N + 1)]

def get_parent(x):
    if parent[x] == x:
        return x
    parent[x] = get_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a = get_parent(a)
    b = get_parent(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


result = 0
max_cost = 0
for a, b, cost in edges:
    if get_parent(a) != get_parent(b):
        union_parent(a, b)
        result += cost
        max_cost = cost

print(result - max_cost)