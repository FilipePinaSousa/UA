#encoding:utf-8
#FP_ex9_P1

def hs():
	print("Preenche os espaços com as tuas informações:")
	print("Saí de casa às (x) horas e (y) minutos.")
	h= float(input("x="))
	m= float(input("y="))
	mt1= h*60 +m
	k1=float(input("Quilómetros percorridos durante o passeio: "))
	p1=float(input("Ritmo do passeio (min/km): "))
	t1=float(p1*k1)
	k2=float(input("Quilómetros percorridos durante o treino rápido: "))
	p2=float(input("Ritmo do treino (min/km): "))
	t2=float(p2*k2)
	kv=float(k2+k1)
	pv=p1
	tv=float(p1*kv)
	tt=float(t1+t2+tv+mt1)
	hch= int((tt//60))
	hcm= tt%60.0
	print ("Chegaste a casa às " +str(hch)+" horas e " + str(hch)+ " minutos!")
hs()	
