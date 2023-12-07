#encoding: utf-8
#FP_ex2_T

def ler_idade():
	idade= input("Idade:")
	
	if int(idade) <0:
		print("ERRO:idade inválida")
		idade= ler_idade()
	
	return idade
	
idade= ler_idade()
print("Tens " + idade+" anos")
		
