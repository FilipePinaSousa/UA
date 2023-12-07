import bisect

lst = []
with open('wordlist.txt', 'r', encoding='utf-8') as file:
    for line in file:
        lst.append(line.strip())


def countwords(lst, pref):
    lst2 = [x[:len(pref)] for x in lst]
    first = bisect.bisect_left(lst2, pref)
    last = bisect.bisect_right(lst2, pref)

    if first == last:
        return 1
    else:
        return len(lst2[first:last])


print(countwords(lst, 'ea'))
