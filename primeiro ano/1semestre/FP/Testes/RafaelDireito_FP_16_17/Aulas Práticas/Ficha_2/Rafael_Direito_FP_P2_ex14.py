#encoding:utf-8

import pprint
import os

def chooseDoc():
	documento = input("Escolha o documento: ")
	if os.path.exists(str(documento)) == False: #verifica se o documento em questao existe
		return chooseDoc()
	return documento
	

def importWords(doc):
	wordlist=[]
	fin=open(doc)
	for lines in fin:
		linesS=lines.strip()
		wordlist.append(linesS)
	#print(wordlist)
	return wordlist

def countWords(lista):
	words=dict()
	ig=-1
	while ig < (len(lista)-1):
		repeat=0
		ig+=1
		ip=-1
		for x in range(0, (len(lista[ig])-2)):
			if lista[ig][x] == lista[ig][x+1]:
				repeat+=1
			words[lista[ig]]=repeat
	return words

def numeroRepeticoes(dicionario):
	palavras=[]
	for p in dicionario.keys():
		palavras.append(p)
	repeticoes=[]
	for r in dicionario.values():
		repeticoes.append(r)
	maiorPalavra=0
	for index in range(0,(len(palavras)-1)):
		if len(palavras[index])>= maiorPalavra:
			maiorPalavra = len(palavras[index])
	#print(repeticoes)
	n=0
	final=dict()
	while n < maiorPalavra:
		lista=[]
		n+=1
		for x in range(0, (len(repeticoes)-1)):
			if repeticoes[x]==n:
				lista.append(palavras[x])
		lista = ordenar(lista)
		if len(lista) !=0:
			final[n]=lista	
	return final	
		
def ordenar(lista):
	if len(lista) <=1:
		return lista
	pivot=lista[0]
	antes = [p for p in lista[1:] if p < pivot]	
	depois = [n for n in lista[1:] if n >=pivot]
	return ordenar(antes)+[pivot]+ordenar(depois)

def main():
	documento = chooseDoc()
	listaPalavras=importWords(documento)
	repeticoes = countWords(listaPalavras)
	final=numeroRepeticoes(repeticoes)
	#pprint.pprint(final)
	print(final)
	return final

main()
