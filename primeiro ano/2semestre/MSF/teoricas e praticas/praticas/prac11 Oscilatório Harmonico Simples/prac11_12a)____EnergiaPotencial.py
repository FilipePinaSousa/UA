import numpy as np
import matplotlib.pyplot as plt

m = 1                       #massa
k = 1                       #constante da mola
w = np.sqrt(k/m)            #frequência angular
t0 = 0                      #tempo inicial
tf = 100                    #tempo final
dt = 0.01                   #passo de tempo
n = int((tf-t0)/dt)         #número de pontos
xeq = 1.5                   #posição de equilíbrio
Em = 0.75                   #energia mecânica

t = np.linspace(t0, tf, n)      #vetor tempo

a = np.empty(n)             #aceleração

x = np.empty(n)         #posição
x[0] = np.sqrt(np.sqrt((2*Em)/k) + xeq**2)      #posição inicial

v = np.empty(n)         #velocidade
v[0] = 0                #velocidade inicial

Ep = np.empty(n)        #energia potencial

for i in range(n-1):                            #loop para calcular a posição, velocidade e aceleração
    a[i] = (-2*k*(x[i]**2-xeq**2)*x[i])/m

    v[i+1] = v[i] + a[i]*dt

    x[i+1] = x[i] + v[i+1]*dt

    Ep[i] = 0.5*k*(x[i]**2 - xeq**2)**2


plt.plot(x, Ep)
plt.show()