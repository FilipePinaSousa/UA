import matplotlib.pyplot as plt
import numpy as np

""" 3. Uma bola de ténis é batida junto ao solo (posição inicial y = 0)com a velocidade 100 km/h, a fazer um ângulo de 
10º com a horizontal e no sentido positivo dum eixo horizontal OX, sendo OY eixo vertical.
a) Calcule a energia mecânica em qualquer instante, no caso de não considerar a resistência do ar.
"""

g = 9.8
t0 = 0
tf = 5
dt = 0.001
x0 = 0
y0 = 0
v0 = 100/3.6
vt = 100/3.6
v0x = v0 * np.cos(np.pi/18)
v0y = v0 * np.sin(np.pi/18)
n = int((tf-t0)/dt)
m = 0.057

t = np.zeros(n+1)
ax = np.zeros(n+1)
ay = np.zeros(n+1)
aresx = np.zeros(n+1)
aresy = np.zeros(n+1)
vx = np.zeros(n+1)
vy = np.zeros(n+1)
x = np.zeros(n+1)
y = np.zeros(n+1)
emec = np.zeros(n+1)

t[0] = t0
vx[0] = v0x
vy[0] = v0y
x[0] = x0
y[0] = y0

for i in range(n):
    t[i+1] = t[i] + dt
    vv= np.sqrt(vx[i]**2 + vy[i]**2)
    ay[i]= -g
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    y[i+1] = y[i] + vy[i] * dt
    emec[i] = 0.5*m*vv**2 + m*g*y[i]

vv= np.sqrt(vx[n]**2 + vy[n]**2)
emec[n] = 0.5*m*vv**2 + m*g*y[n]

print(emec[3])
plt.plot(t, emec)
axis = plt.gca()
axis.set_ylim([0, 25])
plt.show()
