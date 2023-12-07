def genFibonacci(n):
    n1, n2 = 0, 1
    count = 0
    lst = []
    if n == 1:
        lst.append(n2)
    else:
        while count < n:
            lst.append(n1)
            count += 1
            value = n1 + n2
            n1 = n2
            n2 = value
    return lst
