#encoding:utf8

def max2(a,b,c):
	if a > b and a > c:
		M=a
	if b > a and b > c:
		M=b
	else:
		M=c
	
	print("O maior número é o: {} !".format(M))
	return M
	
def v ():
	v1=float(input("Valor 1: "))
	v2=float(input("Valor 2: "))
	v3=float(input("Valor 3: "))
	
	return v1,v2,v3

a,b,c = v()
max2(a,b,c)
		
