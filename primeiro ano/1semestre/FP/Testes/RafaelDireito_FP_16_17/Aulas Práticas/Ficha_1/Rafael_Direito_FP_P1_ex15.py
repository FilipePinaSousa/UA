#encoding:utf8

from math import*

def g(a,b,c,x):	
	
	resultado = a*pow(x,2) + b*x + c
	print("f({})= {}".format (a, resultado))
	return resultado

def valores():
	print ("f(x)= ax² +bx +c")
	a=float(input("a= "))
	b=float(input("b= "))
	c=float(input("c= "))
	print ("f(x)= ({})x² + ({})x + ({})".format (a,b,c))
	x=float(input("x= "))
	return a,b,c,x

a,b,c,x = valores()
g(a,b,c,x)
