lst = [1, 2, 4, 5, 6, 10, 7, 8, 9, 10]


def positionDifferfirstlast(lst):
    for num in lst:
        for num1 in lst:
            if num1 < num:
                break
            else:
                x = num1

    indexes = []
    for y in range(len(lst)):
        if lst[y] == x:
            indexes.append(y)
    return indexes[-1] - indexes[0]


print(positionDifferfirstlast(lst))
