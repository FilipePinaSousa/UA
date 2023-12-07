#FP_ex5/6_P1.py
#encoding:utf8

#defnir o numero de andares que o elevador desce por morador (num dia)
#definir a distancia por morador (num dia)
# calcular par 1 ano ( passando m para km)

def andares():
	a=int(input("Número de andares do pŕedio (a contar com o R/C): ")) 
	at=list(range(1, a))
	ab=len(at)
	print ("O pŕedio tem os seguintes andares: RC e "+ str(at))
	print ("Assim, sem contar com o RC, o prédio tem " + str(ab) + " andares")
	return at
	
def altura():
	at= andares()
	ad = sum(4*at)
	h =int(input("Altura de cada andar: "))
	htm = h*ad
	htk = 1000*htm
	print ("Num dia, o elevador viaja a distância equivalente a " +str(ad) + " andares. O que equivale a "+str(htm)+" metros, ou a " +str(htk)+" kilómetros")
	return htk

def ano():
	htk = altura()
	ano = input("O ano em questão é bissexto? (s/n)")
	
	if ano== "s":
			htka=366 * htk
			print("Nesse ano, o elevador percorreu "+str(htka)+" kilómetros.")
		
	elif ano=="n":
			htka=365 * htk
			print("Nesse ano, o elevador percorreu "+str(htka)+" kilómetros.")
		
	else:
			print ("Erro! Não assinalou se o ano é, ou não, bissexto")
	return htk
	
def vel():
	htk = ano()
	htm= 1000*htk
	t = htm * 1
	th = t/3600
	th= round(th,2)
	print ("O elevador este a funcionar durante "+str(th)+" horas, num ano.")

vel()
				
