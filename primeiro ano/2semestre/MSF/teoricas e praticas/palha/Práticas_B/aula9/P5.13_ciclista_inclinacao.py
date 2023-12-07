import matplotlib.pyplot as plt
import numpy as np

#Problema 13
#O ciclista do problema anterior sobe uma colina com uma inclinação de 5º.
#a) Quanto tempo demora a percorrer 2 km?
#b) Qual a sua velocidade terminal?

# Agora tempos que considerar a influencia de Px

g = 9.8
t0 = 0
tf = 500
dt = 0.001
x0 = 0
v0 = 1
v0x = v0 * np.cos(np.pi/18)
n = int((tf-t0)/dt)
m = 75
area = 0.30
pot = 0.4 * 735.5
cres = 0.9
u = 0.004
pAr = 1.225
px = m*g*np.sin(np.pi/36)


t = np.zeros(n+1)
ax = np.zeros(n+1)
aresx = np.zeros(n+1)
vx = np.zeros(n+1)
x = np.zeros(n+1)

t[0] = t0
vx[0] = v0x
x[0] = x0


for i in range(n):
    t[i+1] = t[i] + dt
    ax[i] = (pot/vx[i]- cres*0.5*area*pAr*vx[i]**2 - u*m*g*np.cos(np.pi/36) - px)/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i] * dt

plt.plot(t,vx)
plt.show()

plt.plot(t,x)
plt.show()

vt = np.max(vx)
print("Velocidade terminal: ", vt)

for i in range(n+1):
    if(np.abs(x[i]-2000) < 0.01): print("Tempo que leva a percorrer 2km: ", t[i])