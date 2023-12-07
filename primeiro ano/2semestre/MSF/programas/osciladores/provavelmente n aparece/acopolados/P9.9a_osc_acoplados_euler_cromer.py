import matplotlib.pyplot as plt
import numpy as np

t0 = 0.0
tf = 40
dt = 0.001
n = int((tf-t0)/dt)
k = 1
k2 = 0.5
m = 1
xAeq = 1
xBeq = 1.2
xA0 = xAeq + 0.05
xB0 = xBeq
vA0 = 0
vB0 = 0

t = np.zeros(n+1)
xA = np.zeros(n+1)
vxA = np.zeros(n+1)
axA = np.zeros(n+1)
xB = np.zeros(n+1)
vxB = np.zeros(n+1)
axB = np.zeros(n+1)


xA[0] = xA0
vxA[0] = vA0
xB[0] = xB0
vxB[0] = vB0


for i in range(n):
    t[i+1] = t[i] + dt

    axA[i] = (-k*(xA[i]-xAeq) - k2*((xA[i]-xAeq)-(xB[i]-xBeq)))/m
    vxA[i+1] = vxA[i] + axA[i] * dt
    xA[i+1] = xA[i] + vxA[i+1] * dt

    axB[i] = (-k*(xB[i]-xBeq) + k2*((xA[i]-xAeq)-(xB[i]-xBeq)))/m
    vxB[i+1] = vxB[i] + axB[i] * dt
    xB[i+1] = xB[i] + vxB[i+1] * dt  


plt.title("Posição x tempo")
plt.plot(t,xA)
plt.plot(t,xB)
plt.legend(["A", "B"])
plt.grid()
plt.show()
