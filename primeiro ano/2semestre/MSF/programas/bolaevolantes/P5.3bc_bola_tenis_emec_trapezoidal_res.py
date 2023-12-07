import matplotlib.pyplot as plt
import numpy as np

# com resistencia do ar
""" 3. Uma bola de ténis é batida junto ao solo (posição inicial y = 0)com a velocidade 100 km/h, a fazer um ângulo de 
10º com a horizontal e no sentido positivo dum eixo horizontal OX, sendo OY eixo vertical.
b) Considerando a resistência do ar, calcule a energia mecânica nos três instantes
t0 = 0, t1 = 0.4 s e t2 = 0.8 s.
c) Considerando a resistência do ar, calcule o trabalho realizado pela força de resistência do ar até às posições nos 
três instantes
t0 = 0, t1 = 0.4 s e t2 = 0.8 s 

Use a aproximação trapezoidal para calcular os integrais. A velocidade terminal da bola de ténis é 100 km/h. AS 
massa da bola é 57 g.
"""

g = 9.8
t0 = 0
tf = 1
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
f = np.zeros(n+1)
integral = np.zeros(n+1)

t[0] = t0
vx[0] = v0x
vy[0] = v0y
x[0] = x0
y[0] = y0

dres = g/vt**2
for i in range(n):
    t[i+1] = t[i] + dt
    vv= np.sqrt(vx[i]**2 + vy[i]**2)
    aresx[i] = -dres*vv*vx[i]
    aresy[i] = -dres*vv*vy[i]
    ax[i] = aresx[i]
    ay[i]= -g+aresy[i]
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    y[i+1] = y[i] + vy[i] * dt
    f[i] = m * aresx[i] * vx[i] + m * aresy[i] * vy[i]   # soma dos integrais é o integral das somas
    integral[i] = dt * ((f[0]+f[i])*0.5+np.sum(f[1:i]))
    emec[i] = 0.5*m*vv**2 + m*g*y[i]

vv= np.sqrt(vx[i+1]**2 + vy[i+1]**2)
integral[i+1] = dt * ((f[0]+f[i+1])*0.5+np.sum(f[1:i+1]))
emec[i+1] = 0.5*m*vv**2 + m*g*y[i+1]

for i in range(n):
    if(t[i]==0): print("Trabalho (W) t=0: ",integral[i])
    if(0.3999<t[i]<0.4001): print("Trabalho (W) t=0.4: ",integral[i])
    if(0.7999<t[i]<0.8001): print("Trabalho (W) t=0.8: ",integral[i])

for i in range(n):
    if(t[i]==0): print("Emec t=0: ", emec[i])
    if(0.3999<t[i]<0.4001): print("Emec t=0.4: ",emec[i])
    if(0.7999<t[i]<0.8001): print("Emec t=0.8: ",emec[i])

for i in range(n):
    if(t[i]==0): print(emec[i] - integral[i])
    if(0.3999<t[i]<0.4001): print(emec[i] - integral[i])
    if(0.7999<t[i]<0.8001): print(emec[i] - integral[i])

plt.plot(t,emec)
plt.plot(t,integral)
plt.plot(t,emec-integral)
plt.show()