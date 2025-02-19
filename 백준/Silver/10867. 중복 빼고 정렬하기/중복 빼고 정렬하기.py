import sys

N = int(sys.stdin.readline().rstrip())
num_set = set(list(map(int, sys.stdin.readline().split())))

num_list = list(num_set)
num_list.sort()

print(*num_list)