#encoding:utf-8

""" Passos para resolução:

	1-Pedir o numero máx e verificá-lo
	2-Criar sequencia de numeros
	3-criar um for com os mesmo nr da sequencia
	4-dividir cada elemento da sequencia pelo for
	5-Os que derem resto=0 adicionar a uma lista A
	6-Criar  outra lista (B) com a sequencia de nrs
	7-Se um elemento de B não estiver em A adicionar à lista C
	8- Nr primos estarao na lista C
"""

#fornecer um número.......................................................................

def limite():
	l= input("Número limite: ")
	verificar(l)
	l=int(l)
	return l

#Verificar se o o número fornecido é um inteiro positivo...................................

def verificar(x):
	for a in x:
		if a not in ["1","2","3","4","5","6","7","8","9","0"]:
			print ("Insira um número inteiro não negativo")
			return limite()
	else:
		return True
		
#criação das listas........................................................................

lista_inicial=[]
lista_divisao=[]
lista_primos=[]
b=[]

#preencher lista_inicial...................................................................

def preencher(x):
	for a in range(0,(x+1)):
		lista_inicial.append(a)
	return lista_inicial
	
#ver as divisoes...........................................................................	
	
def divisao (x):
	inicial_index=0
	while inicial_index < (len(lista_inicial)-1):
		inicial_index+=1
		for b in range(2,(x+1)):
			if lista_inicial[inicial_index] % b==0 :
				lista_divisao.append(lista_inicial[inicial_index])
	return lista_divisao

#ver valores repetidos.......................................................................
def repetidos(x):
	#verifica se o primeiro elemento é primo
	
	if x[0] != x[1]:
			lista_primos.append(x[0])
			
	#verifica se os restantes elementos sao primos(exceto o ultimo)
	
	index=0
	while index < (len(x)-2):
		index+=1
		if x[index] != x[index+1] and x[index] != x[index-1] :
			lista_primos.append(x[index])
			
	#verifica se o ultimo elemento é primo
	
	if x[len(x)-1] != x[len(x)-2]:
			lista_primos.append(x[-1])
	print(lista_primos)
	return lista_primos
	
l=limite()
preencher(l)
divisao(l)
repetidos(lista_divisao)

