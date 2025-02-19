import sys

N = int(sys.stdin.readline().rstrip())
words = set()

for i in range(N):
    a = sys.stdin.readline().rstrip()
    words.add(a)

words_list = []
for i in words:
    words_list.append(i)

words_list.sort()
words_list.sort(key=len)

print("\n".join(words_list))