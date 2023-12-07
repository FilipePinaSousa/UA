import matplotlib.pyplot as plt
import numpy as np

""" Problema:
Determinar se é golo ou não, a bola ser chutada do canto (escanteio) com rotação. Implementar o movimento da bola com rotação, 
usando o método de Euler. Modificar um programa anterior que seja semelhante e adicionar a parte do método de Euler 
correspondente à dimensão extra Z """

g = 9.80
vt = 100/3.6
t0 = 0.0
tf = 0.5
dt = 0.001
n = int((tf-t0)/dt)
v0x = 25
v0y = 5
v0z = -50
x0 = 0
y0 = 0
z0 = 23.8
m = 0.45
w = 400  # omega no eixo y (é o único necessário para o cálculo) w = (0,400,0)
pAr = 1.225
r = 0.11
area = np.pi*r**2


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

mag = 0.5*pAr*area*r  # força de magnus (rotação) : Fmagnus = 1/2 * A * pAr * r * w X v
# W x V depende de vx[i] e vz[i], por isso ta no ciclo
dres = g/vt**2

for i in range(n):
    t[i+1] = t[i] + dt
    vv= np.sqrt(vx[i]**2 + vy[i]**2 + vz[i]**2)
    amx = mag*w*vz[i]/m
    amz = -mag*w*vx[i]/m
    ax[i] = -dres*vv*vx[i]+amx
    ay[i]= -g-dres*vv*vy[i]
    az[i] = -dres*vv*vz[i]+amz
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    vz[i+1] = vz[i] + az[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    y[i+1] = y[i] + vy[i] * dt
    z[i+1] = z[i] + vz[i] * dt

if (x[n] < 0 and y[n] > 0 and y[n] < 2.4 and z[n] > 0 and z[n] < 7.3):
    print("Gooooooooool!!")

plt.plot(t, x, "b")
plt.plot(t, y, "r")
plt.plot(t, z, "g")
plt.legend(["x", "y", "z"])
plt.show()

