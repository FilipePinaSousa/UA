#encoding:utf-8

#lista l
l=["1","2","3","4","4","5","6","7","8","9", "7", "6","7"]
l_without_x=[]

#defenir valor de x
def valor():
	x=input("Insira um valor de x: ")
	verificar(x)
	x=int(x)
	return x
	
#verificar o valor de x
def verificar(x):
	for a in x:
		if a not in ["1","2","3","4","5","6","7","8","9","0"]:
			print ("Insira um número inteiro não negativo")
			return valor()
	else:
		return True

#contar repetiçoes e lista sem o numero em questao
def	contador(x, lista):
	index=-1
	contador=0
	while index <(len(lista)-1):
		index+=1
		if x == int(lista[index]):
			contador+=1
		elif x != int(lista[index]):
			l_without_x.append(lista[index])
	return contador, l_without_x
	
#tuplo
def tuplo (x,y):
	t = y,x
	print(t[0:2])
	
	
#executar funçoes
x=valor()
contador, l_without_x = contador(x,l)
tuplo(contador, l_without_x)
		
		
		
		
		
