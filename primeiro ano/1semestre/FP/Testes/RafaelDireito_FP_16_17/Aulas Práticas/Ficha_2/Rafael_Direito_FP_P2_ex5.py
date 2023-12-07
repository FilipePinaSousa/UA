#encoding:utf-8

#ler a lista de jogadores
lista_defesa=[]
lista_ataque=[]

#Estrutura base:Nome, Número de Camisola, Força Defensiva, Força Atacante.
def ler():
	f = open("ficheiro_ex5.txt")
	for dados in f:
		dados = dados.strip()
		lista_dados= dados.split(",")
		lista_defesa.append(lista_dados[2])
		lista_ataque.append(lista_dados[3])
	
def media(x):
	index=-1
	soma=0
	while index < (len(x)-1):
		index+=1
		soma= soma + int(x[index])
		soma=soma

	media_x = soma/len(x)
	return media_x
	


ler()
print("Média de defesa da equipa: "+ str(media(lista_defesa)))
print("Média de ataque da equipa: "+ str(media(lista_ataque)))
