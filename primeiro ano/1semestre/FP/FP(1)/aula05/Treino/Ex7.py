s = input('String: ')
lst = []
for letter in s.strip():
    lst.append(letter)


def shorten(lst):
    str = ''
    for letter in lst:
        if letter.isupper() == True:
            str += letter
    return str


print(shorten(lst))
