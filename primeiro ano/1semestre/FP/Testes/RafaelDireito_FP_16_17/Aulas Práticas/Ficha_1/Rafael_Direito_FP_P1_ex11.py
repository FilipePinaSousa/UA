#encoding:utf-8
#FP_ex11_P1.py
#Copyrights:Rafael Direito

def quantidade ():
	l = int(input("Quantos litros deseja abastecer? "))
	pl = float(input("Preço por litro: "))	
	if l >= 40 :
		custo = round(pl*l,1)
		desconto = round((pl*l) * 0.1, 1)
		cd = custo- desconto
		print ("Usufrui de um desconto de 10%!") 
		print ("Preço = "+ str(custo)+" euros.")
		print ("Desconto = "+ str(desconto)+" euros.")
		print ("Preço Final  = "+ str(cd)+" euros.")
	if l < 40 :
		custo = (pl*l)
		print ("Não usufrui de desconto!") 
		print ("Preço Final = "+ str(custo)+" euros.")

quantidade()
