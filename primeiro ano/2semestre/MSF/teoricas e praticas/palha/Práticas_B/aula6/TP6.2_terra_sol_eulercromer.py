import matplotlib.pyplot as plt
import numpy as np

# Definir a trajetória da Terra a volta do Sol

g = 4*np.pi**2
t0 = 0.0
tf = 4      # 4 anos
dt = 0.01
n = int((tf-t0)/dt)
v0x = 0
v0y = -2*np.pi
x0 = -1
y0 = 0
m = 1 # massa do Sol no Sistema Astronômico


t = np.zeros(n+1)
ax = np.zeros(n+1)
ay = np.zeros(n+1)
vx = np.zeros(n+1)
vy = np.zeros(n+1)
x = np.zeros(n+1)
y = np.zeros(n+1)

t[0] = t0
vx[0] = v0x
vy[0] = v0y
x[0] = x0
y[0] = y0


for i in range(n):
    t[i+1] = t[i] + dt
    r = np.sqrt(x[i]**2 + y[i]**2)
    ax[i] = -g*m/r**3*x[i]
    ay[i] = -g*m/r**3*y[i]
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    x[i+1] = x[i] + vx[i+1] * dt   # diferença: esse usa v[i+1] aqui ao inves de v[i]
    y[i+1] = y[i] + vy[i+1] * dt   # diferença: esse usa v[i+1] aqui ao inves de v[i]

plt.plot(x,y)
plt.show()