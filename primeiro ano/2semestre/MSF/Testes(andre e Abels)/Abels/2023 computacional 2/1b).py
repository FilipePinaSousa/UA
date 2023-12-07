import  numpy as np
import matplotlib.pyplot as plt

g = 9.8
m = 0.057
r = 0.034
p_ar = 1.225
angle = 0
vT = 20
v0Norm = 130 * (1000/3600)

A = np.pi * r**2
D = g / vT**2

v0x = np.cos(angle) * v0Norm
v0y = np.sin(angle) * v0Norm

dt = 0.001
t0 = 0
tf = 20
x0 = np.array([0, 3, 0])
v0 = np.array([30, 0, 0])

def accel(w, v):
    vNorm = np.linalg.norm(v)
    aXRes = -D * vNorm * v[0]
    aYRes = -D * vNorm * v[1]
    aZRes = -D * vNorm * v[2]
    
    F_magnus = 1/2 * A * p_ar * r * np.cross(w, v)
    return np.array([aXRes, -g + aYRes, aZRes]) + F_magnus/m

n = int((tf-t0) / dt + 0.1)
shape = (n + 1, 3)

w = np.array([0, 0, -60])

tRotPos = np.zeros(n + 1)
xRotPos = np.zeros(shape)
vRotPos = np.zeros(shape)
aRotPos = np.zeros(shape)

aRotPos[0] = accel(w, v0)
vRotPos[0] = v0
tRotPos[0] = t0
xRotPos[0] = x0

for i in range(n):
    aRotPos[i + 1] = accel(w, vRotPos[i])
    vRotPos[i + 1] = vRotPos[i] + aRotPos[i] * dt
    xRotPos[i + 1] = xRotPos[i] + vRotPos[i] * dt
    tRotPos[i + 1] = tRotPos[i] + dt
plt.plot(xRotPos[:, 0], xRotPos[:, 1])
plt.xlabel("x(t) (m)")
plt.xlabel("y(t) (m)")
plt.title("Trajetória XoY")
plt.show()

idx = xRotPos[:, 1].argmax()
yRotPosMax = xRotPos[idx, 1]
tRotPosMax = tRotPos[idx]

print("yMax = ", yRotPosMax,"m")
print("tMax = ", tRotPosMax, "s")

for i in range(n):
    if xRotPos[i, 1] * xRotPos[i + 1, 1] < 0:
        idx = i
        break

xRotPosRange = xRotPos[idx, 0]
tRotPosRange = tRotPos[idx]

print("xRange = ", xRotPosRange, "m")
print("tRange = ", tRotPosRange, "s")