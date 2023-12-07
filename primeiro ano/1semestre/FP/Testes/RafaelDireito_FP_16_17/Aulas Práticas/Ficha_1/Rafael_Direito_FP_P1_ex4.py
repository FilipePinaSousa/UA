#encoding: utf8

def distancia():
	milhas = int(input("Milhas percorridas? "))
	km = milhas * 1.61
	print("Ou seja, percorreste  " + str(km)+" quilómetros.")
	return km
	
def tempo():
	print ("Qual o tempo demorado (complete a frase)?")
	minutos = int(input("Demorei (?) minutos  "))
	segundos = int(input("e (?) segundos   "))
	print ("OK, demoraste "+ str(minutos)+" minutos e "+str(segundos)+" segundos!")
	total= 60*minutos + segundos
	return total

def vel():
	km = distancia()
	s = tempo()
	horas= s/3600
	minutos = s/60
	tm = round(minutos/km,2)
	vel = round(km/horas,2)
	print("O tempo médio por km é de " +str(tm)+ " minutos")
	print("A velocidade média é de "+str(vel)+ " km/h." )
	

vel()

	
	
