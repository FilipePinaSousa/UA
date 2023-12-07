import matplotlib.pyplot as plt
import numpy as np

""" 7. Uma mola exerce uma força Fx = -kx(t) , em que k é a constante elástica da mola, num corpo de massa m. 
Considere k = 1 N/m e m = 1 kg.
a) Calcule numericamente a lei do movimento, no caso em que a velocidade inicial é nula e a posição inicial 4 m.
b) Calcule a amplitude do movimento e o seu período, usando os resultados numéricos.
c) Calcule a energia mecânica. É constante ao longo do tempo?
 """

t0 = 0.0
tf = 20
dt = 0.01
n = int((tf-t0)/dt)
k = 1
m = 1
x0 = 4
v0 = 0

t = np.zeros(n+1)
x = np.zeros(n+1)
vx = np.zeros(n+1)
ax = np.zeros(n+1)
emec = np.zeros(n+1)

x[0] = x0
vx[0] = v0


for i in range(n):
    t[i+1] = t[i] + dt
    ax[i] = (-k*x[i])/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i+1] * dt  
    emec[i] = 0.5*m*vx[i]**2 + 0.5*k*x[i]**2   # Emec = Ec + EpotElastica


plt.title("Posição x tempo")
plt.plot(t,x)
plt.show()

for i in range(n):
    if( np.abs(x[i]-np.max(x)) <0.0001): 
        print(t[i]) # imprime os tempos nos quais são atingidos o valor máximo de X
# O período é a diferença entre quaisquer um desses tempos impressos, portanto T = 6.28s

print("Amplitude: ", np.max(x)) # A = 4m

plt.title("Velocidade x tempo")
plt.plot(t,vx)
plt.show()

plt.title("Energia mecância x tempo")
plt.plot(t,emec)
plt.show()