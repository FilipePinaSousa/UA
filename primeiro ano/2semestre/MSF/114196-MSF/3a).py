import numpy as np
import matplotlib.pyplot as plt
g=9.8
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
    x[0]=x0
    vx[0]=v0
    ax[0]=0
    
    for i in range(n):
        vv=np.abs(vx[i])
        ax[i]=-g*np.sin(ang) -u*g*np.cos(ang) -(0.5*cres*A*p_ar*vx[i]*vv)/m + P/(m*vx[i])
        vx[i+1]=vx[i]+ax[i]*dt
        x[i+1]=x[i]+vx[i]*dt
    return x,vx,ax

values =  planonormal_res_1D(x0,v0,n,dt,cres,u,A,m,P,ang=0)
x = values[0]

for i in range(n):
    if (H-0.01)<x[i]<(H+0.01):
        print("distancia:", t[i], "m")
        break
