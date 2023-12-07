#encoding: utf8

def ab():
	a = int(input("Qual o maior número: "))
	b= int(input("Qual o menor número: "))
	if a > b:
		return a,b
	else:
		print("ERRO! O primeiro número é menor que o segundo")
		return False
 
def euclides():
	n1 = int(input("Número maior: "))
	n2 = int(input("Número menor: "))	
	
	if n1 > n2:
		r = n1 % n2
	
		if r == 0:
			n1 = n2
			print ("O máximo divisor comum é: {}".format(n1))
			return n1
		
		while n2 != 0 :	
			r = n2 
			n2 = n1 % n2
			n1 = r
		print ("O máximo divisor comum é: {}".format(n1))
		return n1
	else:
		print("ERRO! O primeiro número é menor que o segundo")
		return False
euclides()
