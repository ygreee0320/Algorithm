N = int(input())
meeting = []
end_time = 0
result = 0

for _ in range(N):
    a, b = map(int, input().split())
    meeting.append((a, b))

meeting.sort(key=lambda x: (x[1], x[0]))

for start, end in meeting:
    if start >= end_time:
        result += 1
        end_time = end

print(result)