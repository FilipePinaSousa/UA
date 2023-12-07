# -*- coding: utf-8 -*-

# Integração numérica de dx/dt = vx,                  pelo Método de Euler
import numpy as np
import matplotlib.pyplot as plt







dt = 0.001 # passo de tempo
tf = 1.0
t0 = 0
x0 = 0
y0 = 3
z0 = 0
v0 = 30
v0x = 30
v0y = 0
v0z = 0

#Componentes de W (para calcular Força de Magnus. É-nos dado)(em x,y,z)







omega_x = 0
omega_y = 0
omega_z = -60







m = 0.057 #Ja convertido para kilogramas
r = 0.034
A = np.power(r, 2) * np.pi






p_ar = 1.225 # kilograma / metro cubico
g = 9.8
vT = 20

n = int((tf - t0) / dt + 0.1) # +0.1 para garantir não arredondar para baixo
print('n',n)

t = np.zeros(n + 1) # n+1 elementos; último índice do n n

x = np.zeros(n + 1)
y = np.zeros(n + 1)
z = np.zeros(n + 1)


vx = np.zeros(n + 1)
vy = np.zeros(n + 1)
vz = np.zeros(n + 1)

ax = np.zeros(n + 1)
ay = np.zeros(n + 1)
az = np.zeros(n + 1)

t[0] = t0

vx[0] = v0x
vy[0] = v0y
vz[0] = v0z

x[0] = x0
y[0] = y0
z[0] = z0



D = g / vT**2 # coeficiente para resistência do ar
mag = 0.5 * A * p_ar * r #coeficiente força Magnus

# Método de Euler (n+1 elementos)

#COnsiderando com a  RESISTENCIA DO AR
for i in range(n):
    
    vv = np.sqrt(np.power(vx[i], 2) + np.power(vy[i], 2) + np.power(vz[i], 2)) # |v|
    amx = -mag * omega_z * vy[i] / m #força de Magnus - x
    amy = mag * omega_z * vx[i] / m #força de Magnus – y

    vx[i + 1] = vx[i] + ax[i] * dt
    vy[i + 1] = vy[i] + ay[i] * dt
    vz[i + 1] = vz[i] + az[i] * dt 
    
    ax[i + 1] = - D * vv * vx[i] + amx
    ay[i + 1] = -g - D * vv * vy[i] + amy 
    az[i + 1] = - D * vv * vz[i]
    
    x[i + 1] = x[i] + vx[i] * dt
    y[i + 1] = y[i] + vy[i] * dt
    z[i + 1] = z[i] + vz[i] * dt
    
    t[i + 1] = t[i] + dt
    
    y_rede = np.interp(12, x, y)
    
    if y[i] > 0 and y[i + 1] < 0:
        x_campo = x[i + 1]

if y_rede > 1:
    if x_campo > 12 and x_campo < 18.4:
        print("Entrou!")
    else:
        print("Saio Fora.")
else:
    print("Na rede.")

print(x_campo) # Alcance da bola
print(y_rede) # Altura a que a bola estava quando passou a rede

plt.xlabel("x(t) m")
plt.ylabel("y(t) m")
plt.grid()
plt.plot(x, y, label = "Bola c/ rotacao")
plt.legend(loc='upper left')