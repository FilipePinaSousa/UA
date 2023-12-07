def removeAllOccurrences(s, t):
    n = len(t)
    while True:
        try:
            p = s.index(t)
            s = s[:p] + removeAllOccurrences(s[p+n:], t)
        except ValueError:
            return s


print(removeAllOccurrences('dogcatdog', 'cat'))
