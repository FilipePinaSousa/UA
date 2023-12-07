
def loadDataBase (fname, produtos):
        with open(fname, 'r') as file:
            for line in file:
                    produto = line.strip().split(';')
                    fname[produto[0]] = (produto[1],produto[2],produto[3],produto[4])
                
def registaCompra (produtos):
    while True:
        codigo = input('Código item: ')
        if codigo == '0':
            break
        else:
            if codigo in produtos:
                preco = float(produtos[codigo][2]) + (float(produtos[codigo][3][:-1])/100)*float(produtos[codigo][2])
                if codigo not in compra:
                    compra[codigo] = [1, preco]
                else:
                    compra[codigo][0] += 1
                    compra[codigo][1] += preco
                print('{}: {:0.2f}€'.format(codigo[0], preco))
            else:
                print('Código inválido!', end=' ')
def fatura(produtos, compra):
   with open('produtos.txt', 'a') as file1:
        total = 0
        for item in produtos:
            total += float(produtos[item][1])
        file1.write(t + str(round(total, 2)) + '\n')
    



	
  #  dict([ i.split(";") for line in values.strip().split(",")])
def options(produtos):
	opcao = "x"
# Use este código para mostrar o menu e ler a opção repetidamente
    MENU = "(C)ompra (F)atura (S)air ? "
    repetir = True
    while repetir:
        # Utilizador introduz a opção com uma letra minúscula ou maiúscula
        op = input(MENU).upper()
        # Processar opção
		if opcao not in ["C","F","S"]:
			print("")
			print("Opção Inválida!!!")
			print("")
			return options()

		if op == "C":
			compra = registaCompra(produtos)

		if op == "F":
			fatura = fatura(produtos,compra)
        if op == "S":
            venda(compras)
            print('Próximo cliente!')
            break
			
	if op =="S":
		registar(codigos,tBruto)




# Não altere este código / Do not change this code
import sys
if __name__ == "__main__":
    main(sys.argv[1:])
