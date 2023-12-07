# encoding:utf8
#FP_ex3_P1.py
def ler_notas():
	e1 = int(input("Nota específica 1: "))
	e2 = int(input("Nota específica 2 (se só utilizou uma específica escreva 0): ")) 
	s = int(input("Média do secundario:"))
	return e1, e2, s
	
def media(e1, e2, s) :
	if e2 == 0:
		return 0.6*s + 0.4*e1
	else:
		return 0.6*s + 0.2*e1 + 0.2*e2
	


def ex3():
	esp1, esp2, sec = ler_notas()
	nota = media(esp1, esp2, sec)
	print ("Nota de acesso: " + str(nota))

ex3()
