#encoding:utf8

palavra = input("Escolha uma palavra: ")
	
def p(palavra):

	d = int(len(palavra))
	a=d-1
	u=palavra[a]
	b=0
	i=palavra[b]
	while b != a:
		if u != i:
			return False
		if u==i:
			a -=1
			b +=1
		return True
	
if p(palavra) == True:
	print("{} é um palíndromo!".format (palavra))
else:
	print("{} não é um palíndromo!".format (palavra))
