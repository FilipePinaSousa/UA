def validar(numero):
    controlo = True
    if len(numero) < 3 or len(numero) > 9:
        controlo = False
    for letra in numero:
        if letra not in '+123456789':
            controlo = False
    return controlo


def registar(numero):
    t_origem = input("Telefone Origem? ")
    while validar(t_origem) == False:
        t_origem = input("Telefone Origem? ")
    t_chegada = input("Telefone Chegada? ")
    while validar(t_chegada) == False:
        t_chegada = input("Telefone Chegada? ")
    duracao = input("Duração (s)? ")
    return [[t_origem, t_chegada, duracao]]


def ler_ficheiro():
    fname = input('Fname: ')
    lst = []
    with open(fname, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.split()
            lst.append(line)
    return lst


def listar(cena):
    lst = []
    for lista in cena:
        if lista[0] not in lst:
            lst.append(lista[0])
    lst2 = sorted(lst)
    print('Clientes: {}'.format([x for x in lst2]))


def fatura(cena):
    numero = input('Numero: ')
    valor = 0
    for lista in cena:
        print(lista[0])
        if numero == lista[0]:
            print('oi')
            if lista[2][0] == 2:
                valor += 0.02
            elif lista[2][0] == '+':
                valor += 0.8
            elif numero[:2] == lista[2][0:2]:
                valor += 0.04
            else:
                valor += 0.10
    print(valor)


def menu():
    print()
    print("1) Registar Chamada\n2) Ler ficheiro\n3) Listar clientes\n4) Fatura\n5) Terminar")


def main():
    op = 0
    while op != 5:
        print("1) Registar Chamada\n2) Ler ficheiro\n3) Listar clientes\n4) Fatura\n5) Terminar")
        op = float(input("Opção? "))
        if op == 1:
            cena = registar()
        elif op == 2:
            cena = ler_ficheiro()
        elif op == 3:
            listar(cena)
        elif op == 4:
            fatura(cena)
        elif op == 5:
            print("Teminado")


if __name__ == '__main__':
    main()
