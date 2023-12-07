import matplotlib.pyplot as plt
import numpy as np

t0 = 0.0
tf = 20
dt = 0.001
n = int((tf-t0)/dt)
k = 1
m = 1
x0 = 4
v0 = 0

t = np.zeros(n+1)
x = np.zeros(n+1)
vx = np.zeros(n+1)
ax = np.zeros(n+1)

x[0] = x0
vx[0] = v0


for i in range(n):
    t[i+1] = t[i] + dt
    ax[i] = -k*x[i]/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i+1] * dt

plt.title("Velocidade")
plt.plot(t,vx)
plt.show()

plt.title("Posição")
plt.plot(t,x)
plt.show() 