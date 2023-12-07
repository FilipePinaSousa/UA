termos = int(input('Quantos termos são? '))

n1, n2 = 0, 1
contador = 0

if termos < 0:
    print('Please enter a valid number')
elif termos == 1:
    print(n1)
else:
    while termos > contador:
        print(n1)
        n3 = n1 + n2
        n1 = n2
        n2 = n3
        contador += 1
