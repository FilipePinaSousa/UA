#encoding:utf-8
#ex18-P2-FP
import os

def listar():
	lista=os.listdir(".")
	return lista

def contar(lista):
	contador=0
	meuNome=[]
	for i in range(0,(len(lista)-1)):
		if "rafa" in lista[i] or "Rafa" in lista[i]:
			contador+=1
			meuNome.append(lista[i])
	print("Existem {} ficheiros com o teu nome!".format(contador))
	print("")
	print("Lista de ficheiros com o teu nome: ")
	print("{}".format(meuNome))

lista=listar()
contar(lista)
