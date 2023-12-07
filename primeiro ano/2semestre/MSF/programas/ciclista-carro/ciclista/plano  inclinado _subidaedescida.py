import numpy as np
import matplotlib.pyplot as plt

P = 0.48 * 735.4975
vi = 0.5
m = 60+12
Cres = 0.9
A = 0.5
p = 1.225
u = 0.01
g = 9.8

ti = 0
tf = 500
dt = 0.01

n = int((tf-ti)/dt)
t = np.linspace(ti, tf, n)

x = np.empty(n)
x[0] = 0

vx = np.empty(n)
vx[0] = vi

v = np.empty(n)
v[0] = vi

ax = np.empty(n)
ax[0] = 0

angs = np.radians(4)
angd = np.radians(1)

for i in range(n-1):
    v[i] = np.sqrt(vx[i]**2)
    if x[i] <= 1500: #subida
        
        ax[i] = -u*g - (Cres/(2*m))*A*p*v[i]*vx[i] + (P/(m*v[i])) - g*np.sin(angs)
        
        vx[i+1] = vx[i] + ax[i]*dt
        
        x[i+1] = x[i] + vx[i]*dt 
    
    if x[i] > 1500: #descida
        
        ax[i] = -u*g - (Cres/(2*m))*A*p*v[i]*vx[i] + (P/(m*v[i])) + g*np.sin(angd)
        
        vx[i+1] = vx[i] + ax[i]*dt
        
        x[i+1] = x[i] + vx[i]*dt 
    
v[n-1] = np.sqrt(vx[n-1]**2)

for i in range(n-1):
    if x[i] < 2000 + dt and x[i+1] > 2000-dt:
        print("Tempo quando atinge 2km = ", t[i])


plt.plot(t, v, color="blue")
plt.xlabel("Tempo (s)")
plt.ylabel("Velocidade (m/s)")
plt.show()
plt.grid()