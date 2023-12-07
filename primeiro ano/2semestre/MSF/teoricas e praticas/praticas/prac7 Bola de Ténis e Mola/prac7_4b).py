import matplotlib.pyplot as plt
import numpy as np

v0 = 130000/3600                                    #Velocidade inicial
teta = np.radians(10)                               #Angulo com a horizontal
dt = 0.001                                          #Passo de tempo
g = 9.8                                             #Aceleração gravítica
t0 = 0                                              #Instante inicial
tf = 2                                              #Instante final
omega = 100                                         #Componente z da rotação
m = 0.057                                           #Massa
r = 0.067/2                                         #Raio
area = np.pi*r**2                                   #Area
dar = 1.225                                         #Densidade do ar
mag = 0.5*dar*area*r/m                              #Força do ar



vt = 100/3.6                                        #Velocidade terminal

n = int((tf-t0)/dt)
t = np.linspace(t0, tf, n)

vx = np.empty(n)
vy = np.empty(n)
vz = np.empty(n)

ax = np.empty(n)
ay = np.empty(n)
az = np.empty(n)

x = np.empty(n)
y = np.empty(n)
z = np.empty(n)

x[0] = -10
y[0] = 1
z[0] = 0

vx[0] = v0*np.cos(teta)
vy[0] = v0*np.sin(teta)
vz[0] = 0

d = g/vt**2

for i in range(n-1):
    vv = np.sqrt(vx[i]**2 + vy[i]**2)
    amx = -mag * omega * vy[i]
    amy = mag * omega * vx[i]

    ay[i] = -d*abs(vv)*vy[i]-g + amy
    ax[i] = -d*vx[i]*abs(vv) + amx
    az[i] = 0

    vy[i+1] = vy[i] + ay[i]*dt
    vx[i+1] = vx[i] + ax[i]*dt
    vz[i+1] = vz[i] + az[i]*dt

    y[i+1] = y[i] + vy[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    z[i+1] = z[i] + vz[i] * dt

for i in range(n-1):
    if (y[i+1] < y[i]):
        print("A altura max é {:0.2f} m".format(y[i+1]))
        plt.plot(x[i+1], y[i+1], "o", label="Altura máxima")
        break

for i in range(n-1):
    if (y[i+1]*y[i] < 0):
        print("Alcance {:0.2f} m".format(x[i+1]))
        plt.plot(x[i+1], y[i+1], "o", label="Alcance")
        break

plt.plot(x, y)
plt.legend()
