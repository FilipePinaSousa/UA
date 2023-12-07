import numpy as np
import matplotlib.pyplot as plt

dt = 0.001
tf = 4
t0 = 0
g = 9.8

n = int((tf-t0)/dt)
t = np.empty(n+1)
y = np.empty(n+1)
vy = np.empty(n +1)
ay = g

y[0] = 40
vy[0]= 0

for i in range(n):
    t[i +1 ] = t[i] + dt
    y[1 +i]= y[i] - vy[i]*dt
    vy[1 +i]= vy[i] + ay*dt

print(t)
plt.plot(t,y)
plt.show()