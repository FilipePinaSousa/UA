#encoding:utf-8

equipas = ["A","B","C","D"]
confronto=[]
confronto_aa=[]
confronto_final=[]

#confrontos possiveis
def confrontos(x):
	index_x=-1
	while index_x < (len(x)-1):
		index_x+=1
		for a in x:
			b= str( x[index_x])+ str(a)
			confronto.append(b)
	return confronto

#retiar aa / bb	

def retirar(x):
	index_x=-1
	while index_x <( len(x)-1):
		index_x+=1
		if x[index_x][0] != x[index_x][1]:
			a= x[index_x]
			confronto_aa.append(a) 

#retirar ab /ba:

def final(x):
	index_x=-1
	while index_x <( len(x)-1):
		index_x+=1
		if x[index_x] not in confronto_final and x[index_x][::-1] not in confronto_final:
			a= x[index_x]
			confronto_final.append(a) 
	print ("Confrontos possiveis: "+ str(confronto_final))
	
#executar funções
confrontos(equipas)
retirar(confronto)
final(confronto_aa)
