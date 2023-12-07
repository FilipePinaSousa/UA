from pydoc import cli


def leitor(fname, carros, clientes):
    with open(fname, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.strip().split(';')
            if line[0] not in carros:
                carros[line[0]] = (line[1], line[2])
            if line[2] not in clientes:
                clientes[line[2]] = []
            clientes[line[2]].append(line[0])
    return


def imprimir(carros):
    matriculas = sorted(carros, key=lambda t: (carros[t][1], t))
    for matricula in matriculas:
        print("{}:('{}','{}')".format(
            carros[matricula][1], matricula, carros[matricula][0]))


def carros_cliente(clientes):
    for nif in clientes:
        print(nif, ':', clientes[nif])


def validar_matricula(matricula):
    lst = matricula.strip().split('-')
    if len(lst) == 3:
        if len(lst[0]) == len(lst[1]) == len(lst[2]) == 2 and lst[0].isdigit() and lst[2].isdigit() and lst[1].isalpha() and lst[1].isupper():
            return True
        else:
            return False
    else:
        return False


def novo_acesso(acessos):
    mat = introduzir_matricula('Matricula: ')
    temp = introduzir_tempo('Tempo: ')
    if mat not in acessos:
        acessos[mat] = []
    acessos[mat] = temp


def introduzir_matricula(matricula):
    while True:
        plate = input(matricula)
        if validar_matricula(plate):
            break
        print('Inválida!', end=' ')
    return plate


def introduzir_tempo(tempo):
    while True:
        time = int(input(tempo))
        if time > 0:
            break
        print('Inválida!', end=' ')
    return time


def escrever_ficheiro(acessos):
    lst = []
    for matricula in acessos:
        for tempo in acessos:
            lst.append(tempo, matricula)
    lst2 = sorted(lst, key=lambda t: int(t[0]), reverse=True)
    with open('parque.csv', 'w', encoding='utf-8') as file:
        for tempo2 in lst2:
            file.write("{};{}\n".format(tempo2[0], tempo2[1]))


def fatura(carros, clientes, acessos):
    while True:
        nif = input('Nif: ')
        if nif in clientes:
            break
        else:
            print('Nif inexistente', end=' ')
    controlo = 0
    print('Fatura NIF: {}'.format(nif))
    print("{:11s} {:11s} {:>11s} {:>8s}".format(
        "Matricula", "Marca", "Duracao", "Custo"))
    for i in clientes[nif]:
        if i in acessos:
            for d in acessos[i]:
                custo = int(d)*0.01
                controlo += custo
                print("{:11s} {:11s} {:>11s} {:>8.2f}".format(
                    i, carros[i][0], d, custo))
    print("{:11s} {:11s} {:>11s} {:>8.2f}".format("Total:", "", "", controlo))


def menu():
    print("\nOpcoes disponiveis:")
    print("0 - Terminar")
    print("1 - Ler ficheiro de clientes")
    print("2 - Imprimir clientes ordenados")
    print("3 - Mostrar matriculas por Cliente")
    print("4 - Adicionar acesso ao parque")
    print("5 - Gravar fatura para um cliente")
    print("6 - Gerar fatura para um cliente")
    while True:
        op = input("Opcao? ")
        if op not in ["0", "1", "2", "3", "4", "5", "6"]:
            print("Opcao invalida!", end=" ")
        else:
            break
    return op


def main():
    carros = {}
    clientes = {}
    acessos = {}
    while True:
        op = menu()
        if op == '0':
            break

        elif op == '1':  # (a)
            s = input('Nome do ficheiro? ')
            leitor(s, carros, clientes)

        elif op == '2':  # (b)
            imprimir(carros)

        elif op == '3':  # (c)
            if len(clientes) > 0:
                carros_cliente(clientes)
            else:
                print('Não existem clientes!')

        elif op == '4':  # (e)
            novo_acesso(acessos)

        elif op == '5':  # (f)
            if len(acessos) > 0:
                escrever_ficheiro('parque.csv', acessos)
            else:
                print('Não existem entradas no Parque!')

        elif op == '6':  # (g)
            nif = input('NIF? ')
            fatura(clientes, carros, acessos, nif)

        else:
            print('Opção inválida')  # Não era pedido...

    print('Obrigado por usar software desenvolvido em FP!')
    return


if __name__ == '__main__':
    main()
