#!/usr/bin/env python
# -*- coding: utf-8 -*-
import json
import pprint

def lerFicheiro(filename):
    fi = open(filename)
    tweets = json.load(fi)
    return tweets
#########################################################################################################################################
def quicksort(l):
    if len(l) <= 1:
        return l

    pivot_key, pivot_val = l[0]
    ant = [(e_k, e_v) for e_k, e_v in l[1:] if e_v < pivot_val]
    pos = [(e_k, e_v) for e_k, e_v in l[1:] if e_v >= pivot_val]
    return quicksort(ant) + [(pivot_key, pivot_val)] + quicksort(pos)#                              WTF???


def ordenar(d):
    #converter dict para lista
    l = []
    for k,v in d.items():
        l.append((k, v))
    return quicksort(l) # recorre à função quicksort para ordenar uma lista
########################################################################################################################################


def detectarHastagMaisPopular(tweets):
    c = dict() # cria um dicionario { (hashtags: contador),...............}
    for t in tweets:
        for h in t['entities']['hashtags']:
            if not h['text'] in c:
                c[h['text']] = 0
            c[h['text']]+=1
    c_ord = ordenar(c) # c_ord é a lista de pares ordenados, pelo nr de utilizações ( Hashtags, nr de utilizações)
    return c_ord[-1] # o ultimo elemento da lista corresponde à hashtag mais usada
		
def maiorUtilizador (tweets):
	c = dict()
	for t in tweets:
		if not t['user']['screen_name'] in c:
			c[t['user']['screen_name']] = 0
		c[t['user']['screen_name']]+=1

	c_ord = ordenar(c)
	maxi = c_ord[-1][1]
	maioresUtilizadores=[]
	n=-1
	while n < (len(c_ord))-1:
		n+=1
		if c_ord[n][1] == maxi:
			maioresUtilizadores.append(c_ord[n]) 
	return maioresUtilizadores	
		
def verified(twitter):
	contador=0
	for t in twitter:
		if t["user"]["verified"] == True :
			contador+=1	
	return contador	#mostra 3 verificados porque o ficheiro json foi alterado
	
def maisAmigos(twitter):
	a=dict()
	for t in twitter:
		if not t["user"]["screen_name"] in a:
			a[t["user"]["screen_name"]]= t["user"]["friends_count"]
	a_ord = ordenar(a)
	
	#ver se há utilizadores com igual número de amigos
	
	mAmigos=[]
	n=-1
	maximo= a_ord[-1][1]
	while n < (len(a_ord)-1):
		n+=1
		if a_ord[n][1] == maximo:
			mAmigos.append(a_ord[n])
			
	return mAmigos
	

def aveiro(twitter):
	contador=0
	for t in twitter:
		if t["place"]["full_name"] == "Aveiro":
			contador+=1
	
	return contador
	
	
		
doc=lerFicheiro("twitter.json")
pprint.pprint(doc)
#print("Utilizador com mais tweets: "+ str(maiorUtilizador (doc)))
#print("Hashtag mais popular: "+ str(detectarHastagMaisPopular(doc)))
#print("Utilizadores 'verificados': "+ str(verified(doc)))
#print("Utilizador com mais 'amigos': "+ str(maisAmigos(doc)))
#print("Nr de utilizadores em Aveiro: "+ str(aveiro(doc)))
