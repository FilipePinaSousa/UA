# -*- coding: utf-8 -*-



# Queda sem resistência do ar
# Integração numérica de dx/dt = vx, 
import numpy as np
import matplotlib.pyplot as plt

t0 = 0
v0x = 30
v0y = 0
v0z = 0
v0 = 30
dt = 0.001 # passo de tempo
tf = 1.0
vT = 20
x0 = 0
y0 = 3
z0 = 0
g = 9.8
n = int((tf - t0) / dt + 0.1) # +0.1 para garantir não arredondar para baixo
print('n',n)

t = np.zeros(n + 1) # n+1 elementos; último índice n




#acelerações,velocidades,posições
vx = np.zeros(n + 1)
ax = np.zeros(n + 1)
x = np.zeros(n + 1)
y = np.zeros(n + 1)
vy = np.zeros(n + 1)
ay = np.zeros(n + 1)
z = np.zeros(n + 1)
az = np.zeros(n + 1)
vz = np.zeros(n + 1)


vx[0] = v0x
vy[0] = v0y
vz[0] = v0z
t[0] = t0
x[0] = x0
y[0] = y0
z[0] = z0
# Método de Euler (n+1 elementos)

#COM RESISTENCIA DO AR
for i in range(n):#pelo Método de Euler
    vx[i + 1] = vx[i] + ax[i] * dt
    ax[i + 1] = -(g/vT**2) * np.sqrt(np.power(vx[i], 2) + np.power(vy[i], 2) + np.power(vz[i], 2)) * vx[i]
    x[i + 1] = x[i] + vx[i] * dt
    
    vy[i + 1] = vy[i] + ay[i] * dt
    ay[i + 1] = -g - (g/vT**2) * np.sqrt(np.power(vx[i], 2) + np.power(vy[i], 2) + np.power(vz[i], 2)) * vy[i]
    y[i + 1] = y[i] + vy[i] * dt
    
    vz[i + 1] = vz[i] + az[i] * dt
    az[i + 1] =  -(g/vT**2) * np.sqrt(np.power(vx[i], 2) + np.power(vy[i], 2) + np.power(vz[i], 2)) * vz[i]
    z[i + 1] = z[i] + vz[i] * dt
    
    t[i + 1] = t[i] + dt
    
    y_rede = np.interp(12, x, y)
    
    if y[i] >= 0 and y[i + 1] < 0:
        x_campo = x[i + 1] #Guarda o alcance da bola (valor de x para y = 0)
    
    
if y_rede > 1:
    if x_campo > 12 and x_campo < 18.4:
        print("Entrou!")
    else:
        print("Saiu fora.")
else:
    print("Na rede.")
    
print(x_campo) # Alcance da bola
print(y_rede) # Altura a que a bola estava quando passou a rede
plt.xlabel("x(t) m")
plt.ylabel("y(t) m")
plt.grid()
plt.plot(x, y, label = "Bola com resistencia do  ar")
plt.legend(loc='upper left')