t = int(input()) # 테스트 케이스 횟수
n = [] # N
d0 = [0] * 41 
d1 = [0] * 41 

for _ in range(t):
    n.append(int(input()))

def fibonacci(n):
    for i in range(2, n + 1):
        d0[i] = d0[i - 1] + d0[i - 2]
        d1[i] = d1[i - 1] + d1[i - 2]
    
for i in n:
    d0[0], d0[1], d1[0], d1[1] = 1, 0, 0, 1
    fibonacci(i)
    print(str(d0[i]) + ' ' + str(d1[i]))
