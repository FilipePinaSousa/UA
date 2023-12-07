

import numpy as np
import matplotlib.pyplot as plt



dt=0.0001
tf=300
n=int(tf/dt+0.1)

t=np.linspace(0,tf,n)

xi = 1.3           #posiçãoinicial
vi = 0             #velocidadeinicial
k = 2
m = 1000
xeq = 1
b = 0.05
f0 = 7.5
wf = 1

v = np.empty(n)     #Criar Vetores
x = np.empty(n)
a = np.empty(n)

v[0] = vi       #Inicializar vetores
x[0] = xi

for i in range(n-1):
    a[i] = (-k/m)*x[i] - (b/m)*v[i] + (f0/m)*np.cos(wf*t[i])    #Acelaração
    v[i+1] = v[i] + a[i] * dt   #Velocidade
    x[i+1] = x[i] + v[i+1]*dt   #Posição

plt.figure()
plt.plot(t,x,label='Ex b')
plt.ylabel("X")
plt.xlabel("T")
plt.grid()
plt.show()