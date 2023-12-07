import pprint
import json

def abrirfich(fich):
	fl = open(fich)
	doc = json.load(fl) 
	return doc

def conv(dic):
	l = []
	for k ,v in dic.items():
		l.append((k, v))
	l_ord = ordenar(l)
	return l_ord

def ordenar(lista):
	if len(lista) < 1:
		return lista
	pivot_key , pivot_value = lista[0]
	ant = [(k, v) for k, v in lista[1:] if v < pivot_value]
	dps = [(k ,v) for k, v in lista[1:] if v >= pivot_value]
	return ordenar(ant) + [(pivot_key, pivot_value)] + ordenar(dps)
		
def contarhastags(doc):
	dic = dict()
	for twet in doc:
		for hastg  in twet['entities']['hashtags']:
			if not hastg['text'] in dic:
				dic[hastg['text']] = 0
			dic[hastg['text']] += 1
	dic_ord = conv(dic)
	mhasht = dic_ord[len(dic_ord)-1]
	return mhasht			

def contarutil(doc):
	dic = dict()
	for twet in doc:
		if not twet['user']['screen_name'] in dic:
			dic[twet['user']['screen_name']] = 0
		dic[twet['user']['screen_name']] += 1
	dic_ord = conv(dic)
	muser = dic_ord[len(dic_ord)-1]
	return muser
def contadorver(doc):
	x = 0
	for twet in doc:
		if twet['user']['verified'] == 'true':
			x += 1
	return x
def maisamigos(doc):
	dic = dict()
	for twet in doc:
		if not twet['user']['screen_name'] in dic:
			dic[twet['user']['screen_name']] = twet['user']['friends_count'] 
	dic_ord = conv(dic)
	mfriend = dic_ord[len(dic_ord)-1]
	print(mfriend)
	return mfriend
		
def emaveiro(doc):
	cont = 0
	for twet in doc:
		if 'Aveiro' in twet['place']['full_name']:
			cont += 1
	return cont
			
doc = abrirfich('twitter.json')
maisamigos(doc)
pprint.pprint(emaveiro(doc))



 




	
