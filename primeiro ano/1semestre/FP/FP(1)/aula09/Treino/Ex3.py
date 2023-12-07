lst = [1, 2, 3, 4, 5, 6, 7, 8]


def mediana(lst):
    lst.sort()
    x = int(len(lst)/2)
    if len(lst) % 2 != 0:
        mediana_index = len(lst) // 2
        value = lst[mediana_index]
    else:
        mediana = (lst[x] + lst[x-1])/2
        value = mediana
    return value


print(mediana(lst))
