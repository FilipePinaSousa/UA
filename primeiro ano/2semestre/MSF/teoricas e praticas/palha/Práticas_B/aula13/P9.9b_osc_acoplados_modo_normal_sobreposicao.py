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
w1 = np.sqrt(k/m)
w2 = np.sqrt( (k+2*k2)/m )
a1 = 0.025
a2 = 0.025
phi1 = 0
phi2 = 0

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

    xA[i+1] = xAeq + a1*np.cos(w1*t[i]+phi1) + a2*np.cos(w2*t[i]+phi2)
    xB[i+1] = xBeq + a1*np.cos(w1*t[i]+phi1) - a2*np.cos(w2*t[i]+phi2)


plt.title("Posição x tempo")
plt.plot(t,xA)
plt.plot(t,xB)
plt.legend(["A", "B"])
plt.grid()
plt.show()
