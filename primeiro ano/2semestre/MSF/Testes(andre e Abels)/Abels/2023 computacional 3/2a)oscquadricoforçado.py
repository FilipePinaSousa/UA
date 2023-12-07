import numpy as np
import matplotlib.pyplot as plt

k = 1
m = 1
b = 0.02
F0 = 7.5 
Wf = 1 
alpha = 0.15

def acelera(t,x,v):
    F_amort = -b * v
    F_ext = F0 * np.cos(Wf * t)
    F_x = - 4 * (alpha * x ** 3)
    return  (F_amort + F_ext + F_x) / m

def rk4(t,x,vx,acelera,dt):
    ax1=acelera(t,x,vx)
    c1v=ax1*dt
    c1x=vx*dt
    ax2=acelera(t+dt/2.,x+c1x/2.,vx+c1v/2.)
    c2v=ax2*dt
    c2x=(vx+c1v/2.)*dt 
    ax3=acelera(t+dt/2.,x+c2x/2.,vx+c2v/2.)
    c3v=ax3*dt
    c3x=(vx+c2v/2.)*dt
    ax4=acelera(t+dt,x+c3x,vx+c3v)
    c4v=ax4*dt
    c4x=(vx+c3v)*dt
     
    xp=x+(c1x+2.*c2x+2.*c3x+c4x)/6.
    vxp=vx+(c1v+2.*c2v+2.*c3v+c4v)/6.
    return xp,vxp

t0 = 0
tf = 100
dt = 0.001
x0 = 2
v0 = 0

t = np.arange(t0, tf, dt)

x, v = rk4(t,x0,v0,acelera,dt)

plt.plot(t, x)
plt.xlabel('Tempo (s)')
plt.ylabel('X(m)')
plt.title('Oscilador quártico forçado')
plt.show()
