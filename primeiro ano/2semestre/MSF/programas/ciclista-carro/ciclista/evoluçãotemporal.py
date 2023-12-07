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
tf = 300
dt = 0.001

n = int((tf-ti)/dt)
theta = np.deg2rad(4)

px = m*g*np.sin(theta)

fat = u*m*g

x = np.empty(n+1)
x[0] = 0

vx = np.empty(n+1)
vx[0] = vi

v = np.empty(n+1)
v[0] = vi

ax = np.empty(n+1)
ax[0] = 0
t = np.empty(n+1)
t[0]= 0

for i in range(n):

    t[i+1] = t[i] + dt
    v[i] = np.sqrt(vx[i]**2)
    
    ax[i] = (-px - fat- (Cres/(2))*A*p*v[i]*vx[i] + (P/(vx[i])))/m
    
    vx[i+1] = vx[i] + ax[i]*dt
    
    x[i+1] = x[i] + vx[i]*dt 


for i in range(n):
    if(x[i] < 1500 + 10*dt and x[i] > 1500 - 10*dt):
        print(t[i])

    

plt.plot(t, v, color="blue")
plt.xlabel("Tempo (s)")
plt.ylabel("Velocidade (m/s)")
plt.show()
plt.grid()