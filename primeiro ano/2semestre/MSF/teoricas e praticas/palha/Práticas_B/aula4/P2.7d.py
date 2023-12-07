import numpy as np
import scipy as sp
import matplotlib.pyplot as plt


dt=0.01
tf=4.0
n=int(tf/dt+0.1)
print('n',n)

t=np.zeros(n+1)
vy=np.zeros(n+1)
ay=np.zeros(n+1)
y=np.zeros(n+1)

g=9.80      # m/s**2
vt=100/3.6  # m/s
vy0=10      # m/s
vy[0]=vy0
t[0]=0
y[0]=0

D = g/vt**2

for i in range(n):
    t[i+1]=t[i]+dt
    vmodule=np.abs(vy[i]) 
    ay[i]=-g-D*vmodule*vy[i]
    vy[i+1]=vy[i]+ay[i]*dt       
    y[i+1]=y[i]+vy[i]*dt  

for i in range(n):
    if vy[i+1] > 0-0.05  and  vy[i+1] < 0+0.05:
        print('altura máxima: tempo- ',t[i+1], "altura-", y[i+1])      
        
for i in range(n):
    if y[i+1] < 0.1  and  y[i+1] > -0.1:
        print('tsolo: ',t[i+1])      

plt.plot(t,y)
plt.show()