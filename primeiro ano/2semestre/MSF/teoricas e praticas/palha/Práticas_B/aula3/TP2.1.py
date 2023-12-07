import matplotlib.pyplot as plt
import numpy as np

t0 = 0
deltaT = 0.1
tf = 4
n = int((tf-t0)/deltaT)
g = 9.8
t = np.linspace(0,5,n)
x = [0]

for i in range(1,n):
    vx = g * deltaT * (i-1)
    x.append(x[i-1] + vx * deltaT)


plt.plot(t,x,"o")
plt.plot(t,0.5*g*(t**2))
plt.show()