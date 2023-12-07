#encoding:utf-8
# FP_ex8_P1

def lucro():
	pf=float(input("Qual o preço de fabrico: "))
	iva=float(input("Qual o iva do artigo (%)? "))
	ta =float(input("Qual o valor dos royalties? "))
	pc=float(input("Qual o preço de capa do livro? "))
	l = (pc-ta)/(1+ (iva/100)) -pf
	print("O lucro por livro é de " + str(round(l,2)) + " euros.")
	return l,iva,pc,ta,pf
	
def final():
	l,iva,pc,ta,pf = lucro()
	i=int(input("Qual o numero de livros impressos? "))
	lt = l*i
	it=i*(iva/100)*pc
	tt =it + i*ta
	
	print ("O lucro total da livraria foi de " + str(round(lt,2)) +" euros.")
	print("O valor de impostos coletado foi de " + str(round(it,2)) +" euros.")
	print ("O valor total de taxas foi de " + str(round(tt,2)) +" euros.")
	
final()
	
	
	
