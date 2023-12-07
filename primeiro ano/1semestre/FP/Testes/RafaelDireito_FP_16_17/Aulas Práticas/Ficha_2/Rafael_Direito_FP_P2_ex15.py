#encoding:utf-8

def ler_ficheiro():
	fin = open("stocks.csv")
	stocks = dict()
	for line in fin:
		Nome, Data, PreçoAbertura, PreçoMaximo, PreçoMinimo, PreçoFecho, Volume = line.split(',')
		if Nome not in stocks.keys():
			stocks[Nome] = dict() # {}
		stocks[Nome][Data] = (float(PreçoAbertura), float(PreçoMaximo), float(PreçoMinimo), float(PreçoFecho), int(Volume))
	# criaçao de um dicionario dentro de outro dicionário
	# este novo dicionário irá possuir conjuntos de listas
	return stocks

def maior_volume(dicionario):
	lista_volumes=[]
	lista_empresas=[]
	volume=dict() # criação de um dicionario onde se vao armazenar os volumes das açoes
	for nome_empresa in dicionario.keys(): # encontra a todas as chaves do dicionário principal (nomes das empresas)							
		volume[nome_empresa] = 0  # inicialmente, o valor contido na chave nome_empresa é nulo
		for data in stocks[nome_empresa].keys():#acresecenta uma chave chamada data
			volume[nome_empresa] += stocks[nome_empresa][data][4] #SOMA todos os volumes durante as diferntes datas
		lista_volumes.append(volume[nome_empresa])
	for chaves in volume.keys():
		lista_empresas.append(chaves)i
	index=-1
	maximo=0
	while index < (len(lista_volumes)-1):
		index+=1
		if lista_volumes[index] > maximo:
			maximo = lista_volumes[index]
			index_maximo=index
	maior_volume = lista_empresas[index_maximo]
	print("Empresa com maior volume: {} ({} $)".format(maior_volume,lista_volumes[index_maximo]))
	return maior_volume

def valores_maximos(stocks):
	maximos = dict()
	for nomes in stocks.keys():
		dia_max = list(stocks[nomes].keys())[0]#Cria a variavel dia_max
		preco_max = stocks[nomes][dia_max][1] #cria a variavel preço max
		for dia in stocks[nomes].keys():
			##(stocks[nomes][dia]) será os dados das açoes de cada dia
			if stocks[nomes][dia][1] > preco_max: #o index 1 é o preço máximo
				dia_max = dia  #sabe-se o dia em que a ação atingiu o valor máximo
				preco_max = stocks[nomes][dia][1] #preço maximos
		maximos[nomes] = dia_max
		maximos[nomes] = dict()
		maximos[nomes][dia_max] = preco_max
	print(maximos)
	return maximos
	
def valorizacao_diaria(stocks):
	v_diaria= dict()
	v_geral= dict()
	for nomes in stocks.keys():
		dia_max = list(stocks[nomes].keys())[0]#Cria a variavel dia_max
		valor_max = stocks[nomes][dia_max][3]- stocks[nomes][dia_max][0]#cria a variavel preço max
		v_geral[nomes]=0
		for dia in stocks[nomes].keys():
			v_geral[nomes] += (stocks[nomes][dia][3] -  stocks[nomes][dia][0])
			if stocks[nomes][dia][3] -  stocks[nomes][dia][0] > valor_max: 
				valor_max = stocks[nomes][dia][3] - stocks[nomes][dia][0]		
		v_diaria[nomes]=valor_max
	
	#valorizaçao geral
	valorizacaog = 0
	for ng in v_geral.keys():
		if v_geral[ng] > valorizacaog:
			valorizacaog = v_geral[ng]
		if v_geral[ng] == valorizacaog:
			empresag = ng
	
		#v_diaria já está definida
	valorizacao = 0
	for n in v_diaria.keys():
		if v_diaria[n] > valorizacao:
			valorizacao = v_diaria[n]
		if v_diaria[n] == valorizacao:
			empresa = n
	print("Empresa com maior valorizacao DIARIA : {} ({} $)".format(str(empresa), str(valorizacao)))
	print("Empresa com maior valorizacao GERAL : {} ({} $)".format(str(empresag), str(valorizacaog)))
	valorizacoes=dict()
	valor_diaria=[empresa, valorizacao]
	valor_geral=[empresag, valorizacaog]
	valorizacoes["Maior Valorizacao Diaria"] = valor_diaria
	valorizacoes["Maior Valorizacao Geral"] = valor_geral
	#print(valorizacoes)
	return valorizacoes
	
			


stocks = ler_ficheiro()
maior_volume(stocks)
print("")
valores_maximos(stocks)
print("")
valorizacao_diaria (stocks)
