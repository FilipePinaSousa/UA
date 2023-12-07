import numpy as np
import matplotlib.pyplot as plt

dt = 0.01
m = 1           #massa
k = 1           #constante da mola
t0 = 0          #tempo inicial
tf = 200        #tempo final
n = int((tf-t0)/dt)     #número de pontos
w = np.sqrt(k/m)        #frequência angular
t = np.linspace(t0, tf, n)      #vetor tempo
psi = 0         #fase
A = 4           #amplitude

x = A*np.cos(w*t+psi)       #posição

x2 = np.empty(n)            #posição
x2[0] = 4                   #posição inicial

v = np.empty(n)             #velocidade
v[0] = 0                    #velocidade inicial

a = np.empty(n)             #aceleração
a[0] = 0                    #aceleração inicial

for i in range(n-1):            #loop para calcular a posição, velocidade e aceleração
    a[i] = (-k*x2[i])/m
    v[i+1] = v[i] + a[i]*dt
    x2[i+1] = x2[i]+v[i+1]*dt

v_analitico = -w*A*np.sin(w*t+psi)      #velocidade analítica

plt.plot(t, x2)             #plota posição
plt.show()                  #mostra o gráfico