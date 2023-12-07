x = int(input('x: '))
y = int(input('y: '))
target = int(input('target: '))


def closertoTarger(x, y, target):
    targetx = abs(x-target)
    targety = abs(y-target)

    if targetx < targety:
        value = x
    elif targety == targetx:
        if x < y:
            value = x
        else:
            value = y

    return value


print(closertoTarger(x, y, target))
