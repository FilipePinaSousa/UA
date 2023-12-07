#encoding:utf8

def p():
	p1 = input("Escolha uma palavra: ")
	p2 = p1[::-1]
	if p1 == p2:
		print ("{} é um palindromo!".format(p1))
		return True
	if p1 != p2:
		print ("{} não é um palindromo!".format(p1))
		return False
p()
