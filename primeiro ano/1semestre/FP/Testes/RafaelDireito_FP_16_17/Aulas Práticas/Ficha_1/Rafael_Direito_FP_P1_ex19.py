#encoding: utf8

def countdown (n):
	while n>0:
		print (n)
		n=n-1
		
	return n
	
def x():
	x=int(input("Tempo de Countdown: "))
	return x
n=x()
countdown(n)
print("Descolagem!!!")
