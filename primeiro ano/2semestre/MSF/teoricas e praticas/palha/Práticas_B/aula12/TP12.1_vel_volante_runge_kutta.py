import matplotlib.pyplot as plt
import numpy as np
"""
    Integração numérica de equação diferencial de 2ª ordem:
			dvx/dt = ax(t,vx)    de valor inicial
	Erro global:  proporcional a dt**4
    acelera=dvx/dt=Força(t,vx)/massa     : acelera é uma FUNÇÃO
    input:  t = instante de tempo
            vx(t) = velocidade
            dt = passo temporal 
    output: vxp = vx(t+dt)
"""
global g,vt
g = 9.8
vt = 6.80

def acelera(t,vx):
    ax=g-g/vt**2*np.abs(vx)*vx 
    return ax


t0 = 0.0
tf = 20
dt = 0.001
n = int((tf-t0)/dt)

def rk4(t,vx,acelera,dt):
   
    ax1=acelera(t,vx)
    c1v=ax1*dt
    ax2=acelera(t+dt/2.,vx+c1v/2.)
    c2v=ax2*dt       			# predicto:  vx(t+dt) * dt
    ax3=acelera(t+dt/2.,vx+c2v/2.)
    c3v=ax3*dt
    ax4=acelera(t+dt,vx+c3v)
    c4v=ax4*dt
          
    vxp=vx+(c1v+2.*c2v+2.*c3v+c4v)/6.
    return vxp

t = np.zeros(n+1)
vx = np.zeros(n+1)

for i in range(n):
    t[i+1] = t[i] + dt
    vxp = rk4(t[i],vx[i], acelera, dt)
    vx[i+1] = vxp

plt.plot(t, vx)
plt.show()

for i in range(n):
    if(1.9999<t[i]<2.0001): print(vx[i])