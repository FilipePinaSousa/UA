s = input('String: ')


def ispalindrome(s):
    f = ''
    for x in range(len(s)-1, -1, -1):
        f += s[x]
    if f == s:
        return True
    else:
        return False


print(ispalindrome(s))
