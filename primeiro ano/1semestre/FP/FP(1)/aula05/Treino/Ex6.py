s = input('String: ')

lst = []
for n in s:
    lst.append(n)


def countdigits(lst):
    contador = 0
    for n in lst:
        if n.isdigit() == True:
            contador += 1
    return contador


print(countdigits(lst))
