A, B = map(int, input().split())

if B > A:
    A, B = B, A

m = A * B

while B:
    A, B = B, A % B

print(m // A)