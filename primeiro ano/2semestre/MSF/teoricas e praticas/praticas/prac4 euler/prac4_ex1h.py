import matplotlib.pyplot as plt
import numpy as np
# Queda sem resistência do ar
# Integração numérica de dx/dt = vx, pelo Método de Euler

#paraámetros
x0 = 0
dt1=0.01 # passo de tempo1
dt2 = 0.001 # passo de tempo2
t0=0
tf=4.0
y0=0
vy0=0
g=9.80
#inicialização
n=int((tf-t0)/dt2+0.1) # +0.1 para garantir não arredondar para baixo
t=np.zeros(n+1) # n+1 elementos; último índice n
y=np.zeros(n+1)
vy=np.zeros(n+1)
ay=np.zeros(n+1)
vy[0]=vy0
t[0]=t0

# Método de Euler (n+1 elementos)
for i in range(n):
    ay[i] = g # queda livre
    # (em geral pode ser qualquer função de x[i] e vx[i])
    y[i+1]=y[i]+vy[i]*dt2
    vy[i+1]=vy[i] + ay[i]*dt2 # atualizar velocidade sabendo aceleração
    t[i+1]=t[i]+dt2

print(vy[int(3/dt1)]) #29.399999999999913  passo de tempo 0.01 [0,4]s
print(vy[int(3/dt2)]) #29.39999999999819  passo de tempo 0.001 [0,4]s
