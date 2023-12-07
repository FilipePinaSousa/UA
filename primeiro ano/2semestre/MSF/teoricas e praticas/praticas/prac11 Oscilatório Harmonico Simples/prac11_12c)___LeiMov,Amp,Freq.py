import numpy as np
import matplotlib.pyplot as plt

m = 1                   #massa
k = 1                   #constante de mola
w = np.sqrt(k/m)           #frequência angular
t0 = 0          #tempo inicial
tf = 100        #tempo final
dt = 0.01       #passo
n = int((tf-t0)/dt)     #número de passos
xeq = 1.5           #posição de equilíbrio
Em = 3       #energia mecânica

t = np.linspace(t0, tf, n+1)        #vetor tempo

a = np.empty(n+1)       #vetor aceleração

x = np.empty(n+1)           #vetor posição  
x[0] = np.sqrt(np.sqrt((2*Em)/k) + xeq**2)          #condição inicial 

v = np.empty(n+1)       #vetor velocidade
v[0] = 0                #condição inicial

for i in range(n):                              #loop para calcular os vetores
    a[i] = (-2*k*(x[i]**2-xeq**2)*x[i])/m       #aceleração

    v[i+1] = v[i] + a[i]*dt                     #velocidade

    x[i+1] = x[i] + v[i+1]*dt                #posição      

#Amplitude e frequência do movimento
A = np.sqrt((x.max()-x.min())**2)
w = 2*np.pi/(t[x.argmax()]-t[x.argmin()])
print('Amplitude = ', A)
print('Frequência = ', w)

            

plt.plot(t, x)
plt.show()