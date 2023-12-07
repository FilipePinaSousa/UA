import matplotlib.pyplot as plt
import numpy as np

#Problema 12 : Determine a evolução temporal da velocidade de um ciclista, se este
#produzir continuamente a potência 0.4 cv e partir com um empurrão de 1 m/s?
#a) Qual a sua velocidade terminal?
#b) Ao fim de quanto tempo atinge 90% da sua velocidade terminal?
#c) Quanto tempo leva a percorrer 2 km?

g = 9.8
t0 = 0
tf = 200
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
    ax[i] = (pot/vx[i]- cres*0.5*area*pAr*vx[i]**2 - u*m*g)/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i] * dt

plt.plot(t,vx)
plt.show()

vt = np.max(vx)
print("Velocidade terminal: ", vt)

for i in range(n+1):
    if(np.abs(vx[i] - 0.9*vt) < 0.0001): print("Tempo em que atinge 0.90 da velocidade terminal: ", t[i])

for i in range(n+1):
    if(np.abs(x[i]-2000) < 0.01): print("Tempo que leva a percorrer 2km: ", t[i])

