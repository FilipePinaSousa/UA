#encoding:utf8

def n():
	n=int(input("Número: "))
	if n >= 0:
		n1= str(n)
		print(" O numero {} tem {} dígitos!".format( n1, len(n1)))
	else:
		print("O número fornecido tem de ser positivo!")
	return n1
n()
