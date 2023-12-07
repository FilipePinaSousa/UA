import numpy as np
import matplotlib.pyplot as plt

m = 2000
P = -30000
x0 = 0
v0 = 20
u = 0.04
cres = 0.25
A = 2
p_ar = 1.225

ti = 0
tf = 1000
dt = 0.001
n = int((tf-ti)/dt)

t = np.linspace(ti,tf,n+1)

def planoInclinado_res_1D(x0,v0,n,dt,cres,u,A,m,P,ang=-5):
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

values = planoInclinado_res_1D(x0,v0,n,dt,cres,u,A,m,P,ang=-5)
v = values[1]
x = values[0]

plt.xlabel("t (s)")
plt.ylabel("v (m/s)")
plt.plot(t,v)
plt.grid()
plt.show()

for i in range(n):
    if (2000-0.01)<x[i]<(2000+0.01):
        print("Tempo:", t[i], "s")
        break

forca_res = cres/2 * A * p_ar * v**2
forca_atrito = + u * 9.8 * m

potencia = (forca_res + forca_atrito) * v
print("Potencia = " ,potencia, "W")
trabalho = potencia * 2000**2
print("Trabalho realizado = ", trabalho,"J")
