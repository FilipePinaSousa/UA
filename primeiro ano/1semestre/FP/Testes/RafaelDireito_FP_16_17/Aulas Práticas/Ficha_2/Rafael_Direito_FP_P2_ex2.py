#encoding: utf8

nomes=["Ana", "Anabela", "Rodrigo" , "Abel", "Gustavo", "Rafael", "Diogo", "José"]
numeros=["123456978", "45321789","789658965", "102365478", "434567654", "1234567809", "01928374365","09890098"]
n=[]
n_1=[]
n_2=[]
def numero2nome():
	nr=int(input("Nr de telemovel: "))
	nr=str(nr)
	i=-1
	while i < (len(numeros)-1):
		i+=1
		if nr == numeros[i]:
			n.append(nomes[i])
	if len(n) > 0 :
		print (n)
		return n
	else:
		print("O seu numero nao consta na lista!")
		return numero2nome()

def nome2numero ():
	nome= str(input("Nome? "))
	i=-1
	while i < (len(numeros)-1):
		i+=1
		if nome in nomes[i]:
			n_1.append(nomes[i])
			n_2.append(numeros[1])
	if len(n_2) != 0:
		ii=-1
		while ii < (len(n_2)-1):
			ii+=1
			print ( n_1[ii] + " => " + n_2[ii])
	else:		
		print("O seu nome não consta na lista!")
		return nome2numero()
	
def escolha():
	e=int(input("Procurar por (1)nome ou por (2)numero de telefone? "))
	if e == 1:
		nome2numero()
	elif e == 2:
		numeors2nome()
	else:
		print("Escolha uma opçao!")
		return escolha()

escolha()
		
	
