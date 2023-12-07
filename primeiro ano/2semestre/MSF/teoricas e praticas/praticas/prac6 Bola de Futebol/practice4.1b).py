import matplotlib.pyplot as plt
import numpy as np

ti = 0
tf = 1
dt = 0.01
n = int((tf-ti)/dt)
g = 9.8
v0 = 100000/3600
ang = np.radians(10)
D = g/(100000/3600)**2


t = np.linspace(ti, tf, 100)
ax = np.empty(n+1)
ax[0] = D*np.abs(100000/3600)*(100000/3600)*np.cos(10)
ay = np.empty(n+1)
ay[0] = -D*np.abs(100000/3600)*(100000/3600)*np.sin(10)-g 
vx = np.empty(n+1)
vx[0] = v0 * np.cos(ang)
vy = np.empty(n+1)
vy[0] = v0 * np.sin(ang)
y = np.empty(n+1)
y[0] = 0
x = np.empty(n+1)
x[0] = 0

for i in range(n):
    ay[i] = -D*np.abs(100000/3600)*(100000/3600)*np.sin(10)-g
    ax[i] = D*np.abs(100000/3600)*(100000/3600)*np.cos(10)
    vy[i+1] = vy[i] + ay[i]*dt
    vx[i+1] = vx[i] + ax[i]*dt
    y[i+1] = y[i] + vy[i]*dt
    x[i+1] = x[i] + vx[i]*dt
    

                                     
plt.xlabel("x (m)")
plt.ylabel("y (m)")
plt.plot(x, y, label="Euler sem resistência")

plt.legend()
plt.show()
    