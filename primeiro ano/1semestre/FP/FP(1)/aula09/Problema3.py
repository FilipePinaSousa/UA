lst = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]


def mediana(lst):
    lst.sort()
    half = len(lst)//2 - 1
    if len(lst) % 2 == 0:
        return (lst[half] + lst[half+1]) / 2
    else:
        return lst[half+1]


print(mediana(lst))
