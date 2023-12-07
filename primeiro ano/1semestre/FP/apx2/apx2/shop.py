def loadDataBase(fname, produtos):
    with open(fname, 'r') as file:
        for line in file:
            elemento = line.strip().split(';')
            produtos[elemento[0]] = (elemento[1], elemento[2], elemento[3], elemento[4])

def registaCompra(produtos):
    compra = {}
    while True:
        str = input("Code? ")
        parts = str.split(" ")
        if len(parts) > 1:
            quantidade = int(parts[1])
        else:
            quantidade = 1
        code = parts[0]
        if str == "":
            break
        elif code not in produtos:
            continue
        valor = produtos[code]
        if code not in compra:
            compra[code] = quantidade
        else:
            compra[code] += quantidade
        preco = float(valor[2]) * float(quantidade) * (1 + 0.01 * float(valor[3].strip("%")))
        print(valor[0], quantidade, ("{:.2f}".format(preco))) 
    return compra

def fatura(produtos, compras):
    n = int(input("Numero compra? "))
    sec = {}
    Totalpb = 0  
    Totaliva = 0  
    total = 0
    for i in compras[n]:
        quantidade = compras[n][i]  
        preco = quantidade * float(produtos[i][2]) 
        Totalpb += preco
        prod = produtos[i][0]
        iva = 0.01 * float(produtos[i][3].strip("%"))
        Totaliva += iva * preco
        preco_total = preco * (1 + iva)
        total += preco_total
        if produtos[i][1] not in sec:
            sec[produtos[i][1]] = [quantidade, prod, iva, preco_total]
            print(produtos[i][1])
        else:
            sec[produtos[i][1]].append((quantidade, prod, iva, preco_total))
        print("{:5d} {:35s} ({:>2}%) {:10.2f}".format(quantidade, prod, int(iva*100), preco_total)) 
    print("{:>48}{:10.2f}".format("Total Bruto: ", Totalpb)) 
    print("{:>48}{:10.2f}".format("Total IVA: ", Totaliva)) 
    print("{:>48}{:10.2f}".format("Total Liquido: ", total)) 

def main(args):
    produtos = {}
    compras = {}
    contador = 1
    loadDataBase("produtos.txt", produtos)
    for arg in args:
        loadDataBase(arg, produtos)
    
    MENU = "(C)ompra (F)atura (S)air ? "
    repetir = True
    while repetir:
        op = input(MENU).upper()
        if op == "C":
            compra = registaCompra(produtos)
            compras[contador] = compra
            contador += 1
        elif op == "F":
            fatura(produtos, compras)
        elif op == "S":
            break
        else:
            print("A opção introduzida não existe, tente novamente.")
    print("Obrigado!")

import sys
if __name__ == "__main__":
    main(sys.argv[1:])