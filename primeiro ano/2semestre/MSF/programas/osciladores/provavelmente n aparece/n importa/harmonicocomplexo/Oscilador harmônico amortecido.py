import matplotlib.pyplot as plt
import numpy as np

# d) Ao oscilador está aplicada uma força exterior

t0 = 0.0
tf = 2
dt = 0.001
n = int((tf-t0)/dt)
k = 100
m = 1
x0 = 0.1
v0 = 0
b = 2
f0 = 2
wf = 10  # frequencia força externa


t = np.zeros(n+1)
x = np.zeros(n+1)
vx = np.zeros(n+1)
ax = np.zeros(n+1)
emec = np.zeros(n+1)

x[0] = x0
vx[0] = v0


for i in range(n):
    t[i+1] = t[i] + dt
    ax[i] = (-k*x[i]-b*vx[i])/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i+1] * dt  
    emec[i] = 0.5*m*vx[i]**2 + 0.5*k*x[i]**2   # Emec = Ec + EpotElastica


plt.title("Posição x tempo")
plt.plot(t,x)
plt.show()

plt.title("Velocidade x tempo")
plt.plot(t,vx)
plt.show()

plt.title("Energia mecância x tempo")
plt.plot(t,emec)
plt.show()