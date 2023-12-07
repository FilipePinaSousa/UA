import bisect

lst = []
with open('wordlist.txt', 'r') as words:
    for line in words:
        lst.append(line.strip())


def sugestao(lst, pref):
    lst2 = [x[:len(pref)] for x in lst]
    first = bisect.bisect_left(lst2, pref)
    last = bisect.bisect_right(lst2, pref)
    return [x[len(pref):] for x in lst[first:last]]


print(sugestao(lst, 'ab'))
