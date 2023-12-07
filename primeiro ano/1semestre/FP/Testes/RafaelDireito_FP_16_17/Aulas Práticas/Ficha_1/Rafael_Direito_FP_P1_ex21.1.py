#encoding: utf8

def nr():
	n1=int(input("Introduz o maior número: "))
	n2=int(input("Introduz o menor número: "))	
	
	if n1 > n2:
		return n1, n2
	elif n1 < n2:
		print("ERRO! O primeiro número é menor que o segundo!")
		return False
def c():
	n1 ,n2 = nr()
	r=n1%n2
	if r == 0 :
		r=n2
		return r
	if r != 0 :
		while  n2 != 0:
			n1= n2
			n2 = n1%n2
			n2=n1
		return n2

c() = n2
print("O máximo divisor comum é: {}".format (n2))
