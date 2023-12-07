#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  FP_exercicio1_T1.py
#  
#  Copyright 2016 Rafael Direito <rafael@rafael-X555LJ>
#  
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#  
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#  
# 

# encoding: utf8  


def bissexto(ano):
	if ano % 4 ==0 and ano %100 != 0 or ano %400 ==0: 
		return True
	else:
		return False
		
		

def ler_ano():
	ano = input("Qual é o ano?")
	return int(ano)
	
def imprimir(valor):
	if valor:
		print ("O ano é bissexto")
	else:
		print ("O ano não é bissexto")
	
	print ("Obrigado por utilizar")
	
	
a = ler_ano()
b = bissexto(a)
imprimir(b)

