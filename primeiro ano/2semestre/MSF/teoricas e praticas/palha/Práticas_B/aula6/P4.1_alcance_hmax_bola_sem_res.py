import matplotlib.pyplot as plt
import numpy as np

# problema 1 cap 4 alíneas d
""" 1. Uma bola de futebol é chutada com velocidade de 100 km/h, a fazer um ângulo de 10º com o campo (horizontal).
d) Desenvolva um programa que obtenha a lei do movimento e a lei da velocidade em função do tempo, usando o 
método de Euler. Tem confiança que o seu programa está correto? """
# sem resitencia do ar

g = 9.80
t0 = 0.0
tf = 1
dt = 0.001
n = int((tf-t0)/dt+0.001)
teta = np.pi/18
v0 = 100/3.6
v0x = np.cos(teta) * v0
v0y = np.sin(teta) * v0
x0 = 0
y0 = 0

t = np.zeros(n+1)
vx = np.zeros(n+1)
vy = np.zeros(n+1)
x = np.zeros(n+1)
y = np.zeros(n+1)

t[0] = t0
vx[0] = v0x
vy[0] = v0y
x[0] = x0
y[0] = y0
ay = -g
ax = 0

for i in range(n):
    t[i+1] = t[i] + dt
    vy[i+1] = vy[i] + ay * dt
    vx[i+1] = vx[i] + ax * dt   # não faz nada pois ax = 0 (movimento uniforme no eixo X)
    y[i+1] = y[i] + vy[i] * dt
    x[i+1] = x[i] + vx[i] * dt

# analitico
ym = y0 + 1/2*(v0y**2/g) # alura máx
alcance = 2*v0x*v0y/g


print("\nAltura máxima exata (método analítico):", ym)
print("Altura máxima (método de Euler): ", max(y))
print("Alcance máximo exata (método analítico):", alcance)

for i in range(n):
    if y[i] < 0.01 and y[i] > -0.01 and t[i]>0.1:
        print("Alcance máximo (método de Euler):", x[i])

plt.plot(x,y) # trajetória
plt.show()