import matplotlib.pyplot as plt
import numpy as np

ti = 0                          #Instante inicial
tf = 1                          #Instante final
dt = 0.01                       #Passo de tempo
n = int((tf-ti)/dt + 0.1)       #Número de passos/iterações + 0.1 para garantir que não arredondamentos para baixo
g = 9.8                         #Aceleração da gravidade  
v0 = 100/3.6                    #Velocidade inicial
ang = np.radians(10)            #Ângulo


t = np.linspace(ti, tf, 100)
ax = np.empty(n+1)
ax[0] = 0
ay = np.empty(n+1)
ay[0] = -g 
vx = np.empty(n+1)
vx[0] = v0 * np.cos(ang)
vy = np.empty(n+1)
vy[0] = v0 * np.sin(ang)
y = np.empty(n+1)
y[0] = 0
x = np.empty(n+1)
x[0] = 0



for i in range(n):
    ay[i] = -g
    ax[i] = 0
    vy[i+1] = vy[i] + ay[i]*dt
    vx[i+1] = vx[i] + ax[i]*dt
    y[i+1] = y[i] + vy[i]*dt
    x[i+1] = x[i] + vx[i]*dt
    
x_analitico = x[0] + vx[0]*t
y_analitico = y[0] + vy[0]*t - 1/2*g*t**2

idx = y.argmax()
yMax = max(y)
tMax = t[idx]              #Instante
xMax = max(x)              #Alcance

print("Altura máxima: ",yMax)
print("Instante: ",tMax)
print("Alcance: ",xMax)
                                     
plt.xlabel("x (m)")
plt.ylabel("y (m)")
plt.plot(x, y, label="Euler sem resistência")
plt.plot(x_analitico, y_analitico, label="Analítico sem resistência")
plt.grid()
plt.legend()
plt.show()
    