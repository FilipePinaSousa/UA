#encoding:utf8

def f():
	n= int(input("Escolha um número inteiro positivo: "))
	
	if n < 0 :
		print ("Erro! Escolha um número positivo")
			
	if n < 10 and n >= 0 :
		print ("O seu número tem 1 algarismo")
	
	if n >= 10:
		d = 1
		while n > 10:
			n = n / 10
			d += 1
		return d
		
d = f()

print ("O número que escolheu tem {} algarismos!".format (d))
