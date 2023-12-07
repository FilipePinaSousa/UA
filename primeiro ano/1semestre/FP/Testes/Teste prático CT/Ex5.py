position = input('Position: ')


def split(position):
    return [letter for letter in position]


def indicator(postion):
    split(position)
    if ((position[0] == 'a' or position[0] == 'h') and (position[1] == '1' or position[1] == '8')):
        print('Coner')
    elif (position[0] == 'a' or position[0] == 'h' or position[1] == '1' or position[1] == '8'):
        print('Border')
    else:
        print('Inside')


indicator(position)
