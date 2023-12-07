import matplotlib.pyplot as plt
import numpy as np

g = 9.80
v = 130/3.6
vt = 100/3.6
t0 = 0.0
tf = 2
dt = 0.001
n = int((tf-t0)/dt)
v0x = v * np.cos(np.pi/18)
v0y = v * np.sin(np.pi/18)
v0z = 0
x0 = -10
y0 = 1
z0 = 0
m = 0.057
w = -100
r = 67/2 * 1/1000 # diametro/2 e conversão pra metros (diam = 67mm)


t = np.zeros(n+1)
ax = np.zeros(n+1)
ay = np.zeros(n+1)
az = np.zeros(n+1)
vx = np.zeros(n+1)
vy = np.zeros(n+1)
vz = np.zeros(n+1)
x = np.zeros(n+1)
y = np.zeros(n+1)
z = np.zeros(n+1)

t[0] = t0
vx[0] = v0x
vy[0] = v0y
vz[0] = v0z
x[0] = x0
y[0] = y0
z[0] = z0


for i in range(n):
    t[i+1] = t[i] + dt
    vv= np.sqrt(vx[i]**2 + vy[i]**2 + vz[i]**2)
    dres = g/vt**2
    mag=0.5*1.225*r*np.pi*r**2  # força de magnus (rotação)
    amx = -mag*w*vy[i]/m # 100*vy
    amy = mag*w*vx[i]/m # -100*vx
    ax[i] = -dres*vv*vx[i]+amx
    ay[i]= -g-dres*vv*vy[i]+amy
    az[i] = -dres*vv*vz[i]
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    vz[i+1] = vz[i] + az[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    y[i+1] = y[i] + vy[i] * dt
    z[i+1] = z[i] + vz[i] * dt


for i in range(n):
    if y[i] == max(y):
        tymaxEuler = t[i]

# resultados
print("\n")
print("Altura máxima (método de Euler): ", max(y))
print("Tempo que atinge altura máxima (método de Euler):", tymaxEuler)
print("\n")

for i in range(n):
    if y[i] < 0.01 and y[i] > -0.01 and t[i] > 0.1:
        print("Alcance máximo (método de Euler):", x[i], "Tempo em que atinge esse alcance", t[i])

#plt.plot(x, y, "b") # trajetória da bola
plt.show()