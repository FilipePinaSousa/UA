#encoding:utf8

def soma():
	M = int(input("Qual o maior número: "))
	m= int(input("Qual o menor número: "))
	
	if M > m: 
		print("O números compreendidos entre {} e {} são os seguintes: ".format(m,M)) 
		print("_________________________")	
		print("")
		for r in range(m+1,M):
			print(r)
			s = sum(range(m+1,M))
		print("_________________________")
		print("")
		print("A soma dos números compreendidos entre {} e {} é: {}".format(m,M,s))

soma()
