# M2

def ler():
	fin = open("Jornadas.csv")
	findict=dict()
	for line in fin:
		j , a ,v = line.split(",")
		if j not in findict.keys():
			findict[j]=[]
		findict[j].append((a,v[:-1]))
	return findict

def apostar(findict):
	jornada = -1
	apostas=dict()
	validas = ["1","2","1X","X2","X","12","1X2"]
	while int(jornada) < 0 or int(jornada) > 13:
		jornada=input("Jornada? ")
	if jornada != "0":
		betfile=open("Jornada"+jornada+".csv","w+")
		for game in findict[jornada]:
			jogo=1
			result="0"
			while result not in validas:
				result=input("{} vs {} :".format(*game))
			betfile.write(str(jogo)+","+str(result)+"\n")
			apostas[(game)]=str(result)
			jogo+=1
		betfile.close()
	else:
		return apostas,jornada
	return apostas,jornada

def tabela(findict):
	apostas , jornada=apostar(findict)
	jogos=open("Jogos.csv")
	tabel=dict()
	acertou=0
	falhou=0
	n=1
	premio="4"
	if jornada == "0":
		return acertou,falhou,premio,jornada,apostas
	betfile=open("Jornada"+jornada+".csv","r")
	print("Jornada {}".format(jornada))
	for line in jogos:
		data , a , v , g1 ,g2 = line.split(",")
		if (a,v) in findict[jornada]:
			tabel[(a,v)]=(g1,g2[:-1]) #Nao usado
			if g1 > g2[:-1] and "1" in apostas[(a,v)]:
				c = "(Certo)"
				acertou+=1
			elif g1 == g2[:-1] and "X" in apostas[(a,v)]: #elif
				c = "(Certo)"
				acertou+=1
			elif g1 < g2[:-1] and "2" in apostas[(a,v)]: #elif
				c= "(Certo)"
				acertou+=1
			else:
				c="(Errado)"
				falhou+=1	
			print("{:<2} {:>20} {:^3}-{:^3} {:<20} {:>3}: {:<5}".format(n,a,*tabel[(a,v)],v,apostas[(a,v)],c))
			n+=1
	if acertou == 9:
		print("Tem {} certas, 1º Premio".format(acertou))
		premio="1"
	if acertou == 8:
		print("Tem {} certas, 2º Premio".format(acertou))
		premio="2"
	if acertou == 7:
		print("Tem {} certas, 3º Premio".format(acertou))
		premio="3"
	if acertou < 7:
		print("Tem {} certas, Sem premio".format(acertou))
		premio="4"
	return acertou,falhou,premio,jornada,apostas
			
def jogar():
	acertou,falhou,premio,jornada,apostas=tabela(findict)
	saldo=0
	simples=0
	dupla=0
	tripla=0
	while jornada != "0":
		for l in apostas.values():
			if len(l)==1:
				simples+=1
			if len(l)==2:
				dupla+=1
			if len(l)==3:
				tripla+=1
		saldo-=((1**simples)*(2**dupla)*(3**tripla)*9)*0.40
		if premio == "1":
			saldo+=5000
		elif premio == "2":
			saldo+=1000
		elif premio =="3":
			saldo+=100
		print("Saldo: {:.2f} euros".format(saldo))
		acertou,falhou,premio,jornada,apostas=tabela(findict)
	return saldo
		
findict=ler()
jogar()
