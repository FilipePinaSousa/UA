from cmath import pi

import numpy as np
import matplotlib.pyplot as plt

dt = 0.001
tf = 2
t0 = 0
g = 9.8 #Gravidade m/s^^2
n = int((tf-t0)/dt)
m = 0.45 #Massa da bola em kg
raio = 11/100 # Raio- Deve estar em M
A = np.pi*raio**2
v0 = 100/3.6
dAr = 1.225 #Densidade do ar
vt = 100/3.6 #Velocidade terminal
theta = np.deg2rad(16)
w = np.array([0,0,-10])#Velocidade angular
v = np.array([25,5,-50]) #Vetor velocidade em m/s
r0 = np.array([0,0,0])# vetor posição inicial

prodVet = np.cross(w,v)#w vetorial v
cteMagnus = (A*dAr*raio)/(2*m)


t = np.empty(n + 1)
x = np.empty(n + 1)
y = np.empty(n + 1)
z = np.empty(n + 1)
vx = np.empty(n + 1)
vy = np.empty(n + 1)
vz = np.empty(n + 1)
ax = np.empty(n + 1)
ay = np.empty(n + 1)
az = np.empty(n + 1)

t[0] = 0
x[0] = r0[0]
y[0] = r0[1]
z[0] = r0[2]

vx[0] = v0*np.cos(theta)
vy[0] = v0*np.sin(theta)
vz[0] = 0


dres = g/(vt**2)

for i in range(n):
    t[i+1]= t[i] + dt
    prodVet = np.cross(w,[vx[i],vy[i],vz[i]])
    
    amagx = cteMagnus*prodVet[0]
    amagy = cteMagnus*prodVet[1]
    amagz = cteMagnus*prodVet[2]
    vv= np.sqrt(vx[i]**2+ vy[i]**2+ vz[i]**2)
    
    ax[i]=  -dres*vv*vx[i]+ amagx
    ay[i]=  -g -dres*vv*vy[i]+ amagy
    az[i]=  -dres*vv*vz[i]+ amagz
    
    
    vx[i+1]=vx[i]+ax[i]*dt
    vy[i+1]=vy[i]+ay[i]*dt
    vz[i+1]=vz[i]+az[i]*dt
    
    x[i+1]=x[i]+vx[i]*dt
    y[i+1]=y[i]+vy[i]*dt
    z[i+1]=z[i]+vz[i]*dt
    
for i in range(n):
    if (x[i+1] > 20) and (0 < y[i+1] < 2.4) and (-3.75 < z[i+1] < 3.75):
        print("Golo")
        print("A altura da bola vai ser de ", y[i+1], " metros")
        break




plt.plot(t, x, "b")
plt.plot(t, y, "r")
plt.plot(t, z, "g")
plt.legend(["x", "y", "z"])
plt.show()





