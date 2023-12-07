#encoding: utf8

nome="Mariana"

if nome == "Teresa":
	curso= "LEI"
else:
	curso="EET"
	
frase= "A {_nome} é aluna de {_curso}".format (_nome=nome, _curso=curso)

print (frase)

frase2 = "A {} gosta de {}".format (curso,nome) #funciona se trocarmos os argumentos
print (frase2)


numero= 3.1415

print(("{:.2f}").format (numero))
print(("{:+.2f}").format (numero))
print(("{:.0f}").format (numero))


fruta= "banana"

i=0

while i < len(fruta):
	letra= fruta[i]
	print (letra)
	i=i+1 #i=i+1 == i+=1

print ("Mmmmnhamii")



contagem=0
for letra in fruta:
	print (letra)
	contagem+=1 #caso o print(contagem) fique dentro do for... irá imprimir, a seguir à letra, a quantidade de letras já impressas
print(contagem)


cont= 10
while cont > 0:
	cont-=1
	print (("{}...").format(cont))
	
print("Descolagem!!!")
