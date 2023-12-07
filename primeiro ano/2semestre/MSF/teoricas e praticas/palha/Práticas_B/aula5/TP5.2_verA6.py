import matplotlib.pyplot as plt
import numpy as np

# problema 1 cap 4 alíneas e, f, g
# com resitencia do ar
g = 9.80
vt = 100/3.6
dres = g/vt**2
t0 = 0.0
tf = 1
dt = 0.001
n = int((tf-t0)/dt+0.1)
teta = np.pi/18
v0 = 100/3.6
v0x = np.cos(teta) * v0
v0y = np.sin(teta) * v0
x0 = 0
y0 = 0

t = np.zeros(n+1)
ay = np.zeros(n+1)
ax = np.zeros(n+1)
vy = np.zeros(n+1)
vx = np.zeros(n+1)
y = np.zeros(n+1)
x = np.zeros(n+1)

t[0] = t0
vy[0] = v0y
vx[0] = v0x
y[0] = y0
x[0] = x0


for i in range(n):
    t[i+1] = t[i] + dt
    vv = np.sqrt(vx[i]**2 + vy[i]**2)
    ax[i] = -dres*vv*vx[i]
    ay[i]= -g-dres*vv*vy[i]
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    y[i+1] = y[i] + vy[i] * dt


plt.plot(x,y)
plt.show()


for i in range(n):
    if y[i] == max(y):
        tymaxEuler = t[i]

# resultados
print("Altura máxima (método de Euler): ", max(y))
print("Tempo que atinge altura máxima (método de Euler):", tymaxEuler)

for i in range(n):
    if y[i] < 0.01 and y[i] > -0.01 and t[i]>0.1:
        print("Alcance máximo (método de Euler):", x[i], "Tempo em que atinge esse alcance", t[i])
