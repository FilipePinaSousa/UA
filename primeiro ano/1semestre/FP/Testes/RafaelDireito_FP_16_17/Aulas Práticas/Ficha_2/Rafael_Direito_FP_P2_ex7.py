#!/usr/bin/env python
# encoding:utf-8


def new_number():
	l_name=["Ana","Anabela","Carlos","Eduardo"]
	l_number=["962536226","911148909","964567752","963064862"]
	#formar agenda/dicionário
	agenda=dict(zip(l_name,l_number))
	return agenda

def search_name(agenda):
	lista_nomes_possiveis=[]
	pesquisar_nome = input("Nome a procurar: ")
	for nomes in agenda.keys():
		if pesquisar_nome in nomes:
			lista_nomes_possiveis .append(nomes)
	for pessoa in lista_nomes_possiveis:
		print(pessoa+ " ===> " + agenda[pessoa])

def search_number(agenda):
	lista_numbers_possiveis=[]
	pesquisar_numero = input("Número a procurar: ")
	for chave in agenda.keys():
		if pesquisar_numero in agenda[chave]:
			lista_numbers_possiveis.append(chave)
			print( agenda[chave]+ " ===> " + chave)	# Opcao A
	#Opçao B
	#for x in lista_numbers_possiveis:
	#	print( agenda[x]+ " ===> " + x)
			
def escolher():
	option="20"
	while option != "0":
		print("1-Procurar Pessoa: ")
		print("2-Procurar Numero: ")
		print("0 - SAIR")
		option  = input("(1/2)? ")
		
		if option == "1":
			search_name(agenda)
		elif option == "2":
			search_number(agenda)
		elif option == "0":
			print("Bye Bye :( ")
			break
		else: 
			print("Erro!")
			
		
		
agenda = new_number()
escolher()


	
