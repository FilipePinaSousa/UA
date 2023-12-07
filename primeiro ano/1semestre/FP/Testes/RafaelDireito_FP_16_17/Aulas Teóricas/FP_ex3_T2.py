#encoding: utf-8
#FP_ex3_T

def ler_idade():
	idade= input("Idade:")
	
	if int(idade) <0:
		print("ERRO:idade inválida")
		idade= ler_idade()
	
	return idade
	
def contagem(numero):
	if numero <= 500:
		print(numero)
		contagem(numero+1)
		s
contagem(1)
