#encoding:utf8


from  math import pow

def imc():
	p=float(input("Peso(Kg) = "))
	h=float(input("Altura(m) = "))
	i=p/pow(h,2)
	print("O seu IMC é de = {}".format(i))
	return i
imc()
