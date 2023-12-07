import matplotlib.pyplot as plt
import numpy as np

dt=0.5
tf=5.0
t0=0 
x0=0
n=int((tf-t0)/dt)

t=np.zeros(n+1)
x=np.zeros(n+1)
vx=np.zeros(n+1)

g=9.80
v0x=0
vx[0]=v0x
t[0]=t0 
x[0]=x0

for i in range(n): 
    t[i+1]=t[i]+dt
    vx[i]=g*t[i]
    x[i+1]=x[i]+vx[i]*dt

plt.plot(t,x,"o")
plt.plot(t,0.5*g*(t**2))
plt.show()

