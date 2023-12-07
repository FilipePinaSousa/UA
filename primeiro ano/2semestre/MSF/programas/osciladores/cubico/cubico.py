import numpy as np
import matplotlib.pyplot as plt

def oscHarmSimp_1D(x0,v0,k,m,n,dt,alpha,beta):
    x=np.empty(n+1)
    v=np.empty(n+1)
    a=np.empty(n+1)
    Em = np.empty(n+1)
    x[0]=x0
    v[0]=v0
    for i in range(n):
        a[i]=(-k/m*x[i]) - ((3/m*alpha)*(x[i]**2))
        v[i+1]=v[i]+a[i]*dt
        x[i+1]=x[i]+v[i+1]*dt
        Em[i] = 0.5*m*(v[i]**2) + (0.5*k*(x[i]**2) + alpha*x[i]**3)
    
    Em[n] = 0.5*m*(v[n]**2) + (0.5*k*(x[n]**2) + alpha*x[n]**3)

    return x,v,a,Em

x0 = 2.2
v0 = 0
k = 1
m = 1
alpha = 0.05
beta = 0
ti = 0
tf = 20
dt = 0.001
n = int((tf-ti)/dt)

t = np.linspace(ti, tf, n+1)

values = oscHarmSimp_1D(x0,v0,k,m,n,dt,alpha,beta)
x = values[0]
Em = values[3]

plt.plot(t,x)
plt.plot(t,Em)
plt.title("Oscilador cúbico x0=2.2m, vx0=0m/s")
plt.ylabel("x(m)")
plt.xlabel("t(s)")
plt.grid()
plt.show()