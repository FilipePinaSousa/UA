#!/usr/bin/env python

def saldo(caixa):
    s = 0
    for tipo_moeda, numero_moedas in caixa.items():
        s += tipo_moeda * numero_moedas
    return s
       
def troco(qt_recebida, qt_a_receber, caixa):
    t = qt_recebida - qt_a_receber
    if t > saldo(caixa):
        print("Não tenho troco suficiente")
        return caixa
    moedas_troco = []
    for tipo_moeda in [200,100,50,20,10,5,2,1]:
        while t >= tipo_moeda and caixa[tipo_moeda] > 0:
            moedas_troco.append(tipo_moeda)
            caixa[tipo_moeda]-=1
            t-=tipo_moeda

    print('Entregue: {}'.format(moedas_troco))
    return caixa


caixa = {200:2, 100:2, 50:2, 20:2, 10:2, 5:2, 2:2, 1:2}
print('Saldo inicial: {}'.format(saldo(caixa)))

print(troco(2000,1700,caixa))
print('Saldo final: {}'.format(saldo(caixa)))
