#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys

def ler_ficheiro(nome_ficheiro):
    fin = open(nome_ficheiro)
    stocks = dict()
    for line in fin:
        Nome, Data, PreçoAbertura, PreçoMaximo, PreçoMinimo, PreçoFecho, Volume = line.split(",")

        if not Nome in stocks.keys():
            stocks[Nome] = dict()

        stocks[Nome][Data] = (float(PreçoAbertura), float(PreçoMaximo), float(PreçoMinimo), float(PreçoFecho), int(Volume))
    return stocks

def mais_transaccionada(stocks):
    volume_empresa = dict()
    for empresa in stocks.keys():
        volume_empresa[empresa] = 0
        for data in stocks[empresa].keys():
            volume_empresa[empresa] += stocks[empresa][data][4]

    mais_transacionada = list(volume_empresa.keys())[0] 
    volume_maior = volume_empresa[mais_transacionada]

    for e in volume_empresa.keys():
        if volume_empresa[e] > volume_maior:
            mais_transacionada = e
            volume_maior = volume_empresa[e]
    
    return mais_transacionada

def valores_maximos(stocks):
    maximos = dict()
    for e in stocks.keys():
        dia_max = list(stocks[e].keys())[0] 
        preco_max = stocks[e][dia_max][1]

        for dia in stocks[e].keys():
            if stocks[e][dia][1] > preco_max:
                dia_max = dia
                preco_max = stocks[e][dia][1]

        maximos[e] = dia_max 

    return maximos

def data2number(data):
    # '03-Nov-2015'
    
    dia, mes, ano = data.split('-')
    
    conversao = {'Nov': '11', 'Dec': '12'}
    
    return int(   ano+conversao[mes]+dia )
    

if len(sys.argv) > 1:
    stocks = ler_ficheiro(sys.argv[1])

#    print(mais_transaccionada(stocks))

#    print(valores_maximos(stocks))
    
else:
    print("ERRO: deve passar o nome do ficheiro por argumento")
