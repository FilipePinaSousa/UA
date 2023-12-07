# encoding:utf-8
#FP_ex7_P1

from math import *

def vol():
	r=float(input("Qual o raio da esfera (cm) ? "))
	v= (4/3)*pi * pow(r, 3)
	print("O volume da esfera é de "+str(round(v,2))+"cm²")
	
vol()
