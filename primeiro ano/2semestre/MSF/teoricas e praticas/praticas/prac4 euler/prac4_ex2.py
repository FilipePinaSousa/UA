import numpy as np

#a) y(t) = 10t + 4.9t^2
#b) yf=52,0m

# Queda sem resistência do ar
# Integração numérica de dx/dt = vx, pelo Método de Euler
import numpy as np

#paraámetros
x0 = 0
dt=0.001 # passo de tempo
t0=0
tf=1.02
y0=0
vy0=0
g=9.80
#inicialização
n=int((tf-t0)/dt+0.1) # +0.1 para garantir não arredondar para baixo
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
    y[i+1]=y[i]+vy[i]*dt
    vy[i+1]=vy[i] + ay[i]*dt # atualizar velocidade sabendo aceleração
    t[i+1]=t[i]+dt


print(y[int(1.02/dt)]) #0.00098   passo de tempo 0.01
#print(y[2]) #9.800000000000001e-06   passo de tempo 0.001


