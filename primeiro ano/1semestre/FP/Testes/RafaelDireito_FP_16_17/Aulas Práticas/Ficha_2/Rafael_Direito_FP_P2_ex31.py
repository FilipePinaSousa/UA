#encoding:utf-8
#ex 31-P2-FP

#ficheiro = lista_alunos_m1.csv

import os

def readFile():
	ficheiro=input("Ficheiro a ler: ")
	if os.path.exists(ficheiro) ==False:
		print("O ficheiro NAO EXISTE!")
		return readFile()
	fin = open(ficheiro)
	return fin

def createList(ficheiro):
	dados=[]
	lMec=[]
	lNome=[]
	lFp=[]
	lNota=[]
	for lines in ficheiro:
		linesS= lines.strip()
		mec,fp,nota,nome = linesS.split(",")
		lista=[int(mec),int(fp),float(nota),nome]
		dados.append(lista)
		lMec.append(lista[0])
		lFp.append(lista[1])
		lNota.append(lista[2])
		lNome.append(lista[3])
	ordem = int(chooseOrder())
	if ordem == 1:
		x=lMec
		z=0
	elif ordem ==2:
		x=lFp
		z=1
	elif ordem ==3:
		x=lNota
		z=2
	elif ordem ==4:
		x=lNome
		z=3	
	#print(dados)
	ordenado= ordenar(x)	
	
	for index in range(0, (len(ordenado))):
		#print(ordenado[index])
		i=-1
		while i < (len(dados)-1):
			i+=1
			if ordenado[index] == dados[i][z]:
				print(dados[i])

def ordenar(lista):
	if len(lista) <=1:
		return lista
	pivot=lista[0]
	antes= [p for p in lista[1:] if p < lista[0]]
	depois= [n for n in lista[1:] if n >=lista[0]]
	return ordenar(antes)+[pivot]+ordenar(depois)

def chooseOrder():
	print("Como quer ordenar os resultados?")
	print("Por Número Mecanográfico (1)")
	print("Por Número de Incrição na UC (2)")
	print("Por Nota na Avaliação (3)")
	print("Por Nome do Aluno (4)")
	ordem = input("Ordenar por: ")
	if str(ordem) in ["1","2","3","4"]:
		return ordem
	else:
		print("")
		print("ERRO")
		print("")
		return chooseOrder()

def main():	
	fin = readFile()
	dados=createList(fin)

main()
