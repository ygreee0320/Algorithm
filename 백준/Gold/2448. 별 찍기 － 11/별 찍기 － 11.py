import sys
input = sys.stdin.readline

N = int(input())


def recursion(size):
    if size == 3:
        return ["  *  ", " * * ", "*****"]

    star_piece = recursion(size // 2)
    new_stars = []

    for star in star_piece:
        new_stars.append(" " * (size // 2) + star + " " * (size // 2))

    for star in star_piece:
        new_stars.append(star + " " + star)

    return new_stars


print('\n'.join(recursion(N)))