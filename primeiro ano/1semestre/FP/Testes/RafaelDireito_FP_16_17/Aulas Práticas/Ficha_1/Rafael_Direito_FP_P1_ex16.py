#encoding:utf8

def max2(a,b):
	if a > b :
		M=a
		
	else:
		M=b
	
	print("O maior número é o: {}".format(M))
	return M
	
def v ():
	v1=float(input("Valor 1: "))
	v2=float(input("Valor 2: "))
	
	return v1,v2

a,b = v()
max2(a,b)
		
