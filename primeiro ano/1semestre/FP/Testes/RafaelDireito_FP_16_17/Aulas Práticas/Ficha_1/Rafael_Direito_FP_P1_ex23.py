#encoding:utf8

palavra=input("Escolha uma palavra: ")

def palindromo (p):
	i=0
	f=len(p)-1

	while i < len(p):
		if p[i] != p[f]:
			return False
		i+=1
		f-=1
	return True



if palindromo(palavra):
	v=""
else:
	v="nao"
	
print ("{} {} é um palíndromo !".format(palavra,v))
