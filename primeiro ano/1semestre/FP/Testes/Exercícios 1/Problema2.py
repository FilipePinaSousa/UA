with open('Jornadas.csv', 'r', encoding='utf-8') as file:
    dic = {}
    lst = []
    for line in file:
        lst.append(line.rstrip().split(','))

jornada = input('Jornada: ')
with open('jornada' + jornada + '.csv', 'a', encoding='utf-8') as fin:
    for element in lst:
        if jornada == element[0]:
            x = input(element[1] + ' vs ' + element[2] + ': ')
            fin.write(jornada + ', ' + x + '\n')
        if not (1 <= int(jornada) <= 14):
            print('Jornada Inválida')
