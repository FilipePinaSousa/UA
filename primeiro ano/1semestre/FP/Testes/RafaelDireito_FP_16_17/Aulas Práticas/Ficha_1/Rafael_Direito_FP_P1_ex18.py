#encoding: utf8

def r():
	r = float(input("Qual o Valor de r : "))
	return r

def tax(a):
	if a <= 1000:
		res = 0.1 * a
	if a > 1000 and a <= 2000:
		res= 0.2 * a
	if a > 2000:
		res=0.3 * a - 300	
	print("f(r) = {}".format(res))	
	return res


a= r()
tax(a)
