import numpy as np
import matplotlib.pyplot as plt
import sympy as sy







# Queda sem resistência do ar
# Integração numérica de dx/dt = vx, pelo Método de Euler

#parametros
dt=0.01 # passo de tempo
t0=0
tf=4.0
y0=0
vy0=0
g=9.80
x0 = 0
segundos = 3
#inicialização
n=int((tf-t0)/dt+0.1) # +0.1 para garantir não arredondar para baixo
#em versões mais antigas é np.int
t=np.zeros(n+1) # n+1 elementos; último índice n
y=np.zeros(n+1)
vy=np.zeros(n+1)
ay=np.zeros(n+1)
vy[0]=vy0
t[0]=t0
x[0] = x0

# Método de Euler (n+1 elementos)
for i in range(n):
    ay[i] = g # queda livre
# (em geral pode ser qualquer função de x[i] e vx[i])
y[i+1]=y[i]+vy[i]*dt
vy[i+1]=vy[i] + ay[i]*dt # atualizar velocidade sabendo aceleração
t[i+1]=t[i]+dt



indice = (segundos/dt)
print(vy[indice],"m/s")





plt.plot(t,vy,"-")
plt.show()