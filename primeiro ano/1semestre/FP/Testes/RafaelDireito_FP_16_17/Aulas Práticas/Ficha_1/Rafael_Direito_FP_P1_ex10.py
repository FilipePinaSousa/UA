#encoding:utf-8
#FP_ex10_P1

def mm (menor, maior, repetir):
	if repetir <=0:
		return menor, maior
		
	n= float(input("Número: "))
	if n < menor:
		menor = n
		
	if n > maior:
		maior = n
		
	menor, maior = mm(menor, maior, repetir-1)
	return menor, maior



r = int(input("Quantos numeros queres comparar: "))
n = float(input("Numero: "))
print(mm(n, n, r-1))

