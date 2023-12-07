list = []


def inputFloatList():
    while True:
        n = input('Number: ')
        if n == '':
            break
        else:
            value = int(n)
            list.append(value)
    return list


def countLower(lst, v):
    v = int(input('Value: '))
    contador = 0
    for value in lst:
        if value < v:
            contador += 1
    return contador


def minmax(lst):
    if len(lst) == 0:
        return None
    minm = lst[0]
    maxm = lst[0]

    for i in lst:
        if minm < i:
            minm = i
        elif maxm > i:
            maxm = i
    return maxm, minm


def media():
    lista = inputFloatList()
    avg = (minmax(lista)[0] + minmax(lista)[1])/2
    menor1 = countLower(lista, avg)

    print(f'A média do minímo e máximo é {avg}')
    print(f'Os números {menor1} são inferiores à media')


media()
