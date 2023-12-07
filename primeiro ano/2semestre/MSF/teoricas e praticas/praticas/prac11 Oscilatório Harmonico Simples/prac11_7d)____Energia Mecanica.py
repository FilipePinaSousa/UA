import numpy as np
import matplotlib.pyplot as plt

m = 1       #massa
k = 1       #constante da mola
w = np.sqrt(k/m)        #frequência angular
t0 = 0      #tempo inicial
tf = 500        #tempo final
dt = 0.01       #passo de tempo
n = int((tf-t0)/dt)     #número de pontos

t = np.linspace(t0, tf, n+1)        #vetor tempo

a = np.empty(n+1)       #aceleração

x = np.empty(n+1)               #posição
x[0] = 4                    #posição inicial

v = np.empty(n+1)           #velocidade
v[0] = 0                    #velocidade inicial

Em = np.empty(n+1)          #energia mecânica

for i in range(n):              #loop para calcular a posição, velocidade e aceleração
    a[i] = (-k * x[i])/m        #aceleração

    v[i+1] = v[i] + a[i]*dt     #velocidade

    x[i+1] = x[i] + v[i+1]*dt           #posição

    Em[i] = 0.5*m*(v[i]**2) + 0.5*k*(x[i]**2)           #energia mecânica

Em[n] = 0.5*m*(v[n]**2) + 0.5*k*(x[n]**2)           #energia mecânica


plt.plot(t, Em)
plt.show()

