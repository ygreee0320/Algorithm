N = int(input())
student = list(map(int, input().split()))

order = 1
save = []

for i in student:
    save.append(i)

    while save and save[-1] == order:
        save.pop()
        order += 1

if not save:
    print("Nice")
else:
    print("Sad")