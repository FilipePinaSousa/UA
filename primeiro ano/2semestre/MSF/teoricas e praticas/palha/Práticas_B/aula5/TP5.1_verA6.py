import matplotlib.pyplot as plt
import numpy as np

g = 9.80
t0 = 0.0
tf = 1
dt = 0.001
n = int((tf-t0)/dt+0.1)
print("n", n)
v0 = 0
v0y = 4.82 # ângulo teta = 10 graus
v0x = 27.36
y0 = 0
x0 = 0
ax = 0
ay = -g

t = np.zeros(n+1)
vy = np.zeros(n+1)
vx = np.zeros(n+1)
y = np.zeros(n+1)
x = np.zeros(n+1)

t[0] = t0
vy[0] = v0y
vx[0] = v0x
y[0] = y0
x[0] = x0


for i in range(n):
    t[i+1] = t[i] + dt
    vy[i+1] = vy[i] + ay * dt
    vx[i+1] = vx[i] + ax * dt
    y[i+1] = y[i] + vy[i] * dt
    x[i+1] = x[i] + vx[i] * dt

for i in range(n):
    if y[i] == max(y):
        tymaxEuler = t[i]


#plt.plot(x,y)
#plt.show()
#plt.plot(t,y)
#plt.show()

# analitico
ym = y0 + 1/2*(v0y**2/g)
tymaxAn = v0y/g

# resultados
print("\nAltura máxima exata (método analítico):", ym)
print("Altura máxima (método de Euler): ", max(y))
print("Tempo que atinge altura máxima exata (método analítico):", tymaxAn)
print("Tempo que atinge altura máxima (método de Euler):", tymaxEuler)

# o completo está em P4.1.py (porém sem o tempo)