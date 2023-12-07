import re


t = [['coal', 30], ['rice', 50], ['iron', 5], ['rice', 42], ['coal', 45]]

M, Q = 0, 1


def unload(t, m, q):
    for carruagem in t:
        if carruagem[M] == m:
            carruagem[Q] -= q
            if carruagem[Q] <= 0:
                t.pop(t.index(carruagem))
    return t


def merchandise(t):
    dic = {}
    for carruagem in t:
        if carruagem[0] not in dic:
            dic[carruagem[0]] = carruagem[1]
        else:
            dic[carruagem[0]] += carruagem[1]
    return dic


def main():
    print('t:', t)
    #
    q = unload(t, 'rice', 40)
    print('unload(t, "rice", 40) -->', q)
    print('t:', t)
    #
    q = unload(t, 'coal', 50)
    print('unload(t, "coal", 50) -->', q)
    print('t:', t)
    #
    q = unload(t, 'iron', 20)
    print('unload(t, "iron", 20) -->', q)
    print('t:', t)

    d = merchandise(t)
    print(d)


if __name__ == '__main__':
    main()
