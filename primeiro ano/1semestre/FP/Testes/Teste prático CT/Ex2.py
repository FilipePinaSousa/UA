s = input('String: ')
n = int(input('n: '))


def repeatedCharacters(s, n):
    text = ''
    for letter in s:
        text += str(letter) * n
    return text


print(repeatedCharacters(s, n))
