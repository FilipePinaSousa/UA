#encoding:utf8

from math import*

def g(x):
	print ("f(x)= x² -2x +3")
	
	resultado = pow(x,2) -2*x+3
	print("f({})= {}".format (a, resultado))
	return resultado
	
a=float(input("x= "))	
g(a)
