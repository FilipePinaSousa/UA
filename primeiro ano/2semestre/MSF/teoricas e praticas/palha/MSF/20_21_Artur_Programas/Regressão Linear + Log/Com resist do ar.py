# Queda livre sem resistência do ar
# Método de Euler

import numpy as np
import matplotlib.pyplot as plt


dt=0.01                 # INPUT 
tf=4.0
t0=0
n= int((tf-t0)/dt+0.1)

vt = 80 #Velocidade Terminal
print('n',n)

t=np.zeros(n+1)
vy=np.zeros(n+1)
ay=np.zeros(n+1)
y=np.zeros(n+1)

g=9.80
v0y=0
y0=10
t[0]=t0
vy[0]=v0y
y[0]=y0
ay[0] = 0


for i in range(n):
    t[i+1]=t[i]+dt
    vv=np.abs(vy[i])
    dres=g/vt**2
    ay[i]=-g-dres*vv*vy[i]
    vy[i+1]=vy[i]+ay[i]*dt       
    y[i+1]=y[i]+vy[i]*dt    

for i in range(n):
    if vy[i+1] > 0-0.0005  and  vy[i+1] < 0+0.0005:
        print('altura máxima: ',t[i+1],y[i+1],vy[i+1],vy[i+1]*3600/1000)      
        
for i in range(n):
    if y[i+1] < 0.1  and  y[i+1] > -0.1:
        print('solo: ',t[i+1],y[i+1],vy[i+1],vy[i+1]*3600/1000)      

plt.plot(t,y)
plt.show()

