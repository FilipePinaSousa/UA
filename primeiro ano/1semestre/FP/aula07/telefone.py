# Complete este programa como pedido no guião da aula.

def listcontacts(dic):
    """Print the contents of the dictionary as a table, one item per row."""
    print("{:>12s} : {} : {}".format("Numero", "Nome","Morada"))
    for num in dic:
        print("{:>12s} : {} : {}".format(num, dic[num],))

def filterPartName(contacts, partName):
        dic = {}
        partName = input('Parte do nome: ')
        for numero, nome in contacts.items():
            if partName.lower() in nome.lower():
                dic[numero] = nome
        print('Dicionario \n', dic)


def addcontacts(contactos):
    numero = input('Número de telemóvel: ')
    nome = input('Nome do contacto: ')
    if numero in contactos:
        print('Esse contacto ja existe')
    else:
        contactos[numero] = nome
def removecontactos(contactos):
    numero = input('Número de telemóvel: ')
    if numero not in contactos:
        print('O número desejado não existe')
    else:
        contactos.pop(numero)

def procuranumero(contactos):
    numero = input('Número de telemóvel: ')
    if numero not in contactos:
        print(numero)
    else:
        print(contactos[numero])


def menu():
    """Shows the menu and gets user option."""
    print()
    print("(L)istar contactos")
    print("(A)dicionar contacto")
    print("(R)emover contacto")
    print("(N)Procurar número")
    print("(P)Procurar parte do nome")
    print("(T)erminar")
    op = input("opção? ").upper()   # converts to uppercase...
    return op


def main():
    """This is the main function containing the main loop."""

    # The list of contacts (it's actually a dictionary!):
    contactos = {"234370200": "Universidade de Aveiro",
        "727392822": "Cristiano Aveiro",
        "387719992": "Maria Matos",
        "887555987": "Marta Maia",
        "876111333": "Carlos Martins",
        "433162999": "Ana Bacalhau"
        }

    op = ""
    while op != "T":
            op = menu()
            if op == "T":
                print("Fim")
            elif op == "L":
                print("Contactos:")
                listcontacts(contactos)
            elif op == 'A':
                addcontacts(contactos)
            elif op == 'R':
                removecontactos(contactos)
            elif op == 'N':
                procuranumero(contactos)
            elif op == 'P':
                filterPartName(contactos)
            else:
                print("Não implementado!")
        
        

# O programa começa aqui
main()

