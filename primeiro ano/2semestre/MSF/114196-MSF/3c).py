import numpy as np
import matplotlib.pyplot as plt

m = 1800
P = 10000
x0 = 0
v0 = 1
u = 0.04
cres = 0.3
A = 2
H = (3*3600)
ti = 0
tf = 1000
dt = 0.001
n = int((tf-ti)/dt)
p_ar=1.225
t = np.linspace(ti,tf,n+1)

def planonormal_res_1D(x0,v0,n,dt,cres,u,A,m,P,ang=0):
    x=np.empty(n+1)
    vx=np.empty(n+1)
    ax=np.empty(n+1)
    
    p_ar=1.225
    g=9.8
    
    x[0]=x0
    vx[0]=v0
    ax[0]=0
    
    for i in range(n):
        vv=np.abs(vx[i])
        ax[i]=-g*np.sin(ang) -u*g*np.cos(ang) -(0.5*cres*A*p_ar*vx[i]*vv)/m + P/(m*vx[i])
        vx[i+1]=vx[i]+ax[i]*dt
        x[i+1]=x[i]+vx[i]*dt
    return x,vx,ax

values = planonormal_res_1D(x0,v0,n,dt,cres,u,A,m,P,ang=0)
v = values[1]
x = values[0]

plt.xlabel("t (s)")
plt.ylabel("v (m/s)")
plt.plot(t,v)
plt.grid()
plt.show()

for i in range(n):
    if (H-0.01)<v[i]<(H+0.01):
        print("distancia:", t[i], "m")
        break
    
#energia dissipada e a soma de força de atrito e res
forca_res = cres/2 * 2 * p_ar * 1**2
forca_atrito = + u * 9.8 * m


potencia = (forca_res + forca_atrito) * v
print("energia gasta pelo carro: = " ,potencia, "W")
