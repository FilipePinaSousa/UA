import matplotlib.pyplot as plt
import numpy as np

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
    ax[i] = -k*x[i]/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i+1] * dt   # se colocar vx[i] nessa linha ao invés de vx[i+1] (Passar de Euler-Cromer para Euler) o gráfico da energia mecanica não fica mais aprox constante. 
# OBS: Usar passos muitos pequenos dificulta ver a diferença entre os dois métodos.
    emec[i] = 0.5*m*vx[i]**2 + 0.5*k*x[i]**2   # Emec = Ec + EpotElastica

emec[n] = 0.5*m*vx[n]**2 + 0.5*k*x[n]**2 

plt.title("Posição x tempo")
plt.plot(t,x)
plt.show()

plt.title("Velocidade x tempo")
plt.plot(t,vx)
plt.show()



plt.title("Energia mecância x tempo")
plt.plot(t,emec)
axis = plt.gca()
axis.set_ylim([4, 12])
plt.show()