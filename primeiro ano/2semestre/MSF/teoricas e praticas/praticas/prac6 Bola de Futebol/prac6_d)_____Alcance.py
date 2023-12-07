import matplotlib.pyplot as plt
import numpy as np

ti = 0                          #Instante inicial
tf = 1                          #Instante final
dt = 0.01                       #Passo de tempo
n = int((tf-ti)/dt + 0.1)       #Número de passos/iterações + 0.1 para garantir que não arredondamentos para baixo
g = 9.8                         #Aceleração da gravidade  
v0 = 100000/3600                #Velocidade inicial
ang = np.radians(10)            #Ângulo
vT = 100000/3600                #Velocidade Terminal
D= g / vT**2 
                  
t = np.linspace(ti, tf, 101)
ax = np.empty(n+1)
ax[0] = 0
ay = np.empty(n+1)
ay[0] = -g 
v = np.empty(n+1)
v[0] = v0
vx = np.empty(n+1)
vx[0] = v0 * np.cos(ang)
vy = np.empty(n+1)
vy[0] = v0 * np.sin(ang)
y = np.empty(n+1)
y[0] = 0
x = np.empty(n+1)
x[0] = 0

for i in range(n):
    v[i] = np.sqrt(vy[i]**2 + vx[i]**2)
    ay[i] = -g - D*vy[i]*v[i]
    ax[i] =  - D*vx[i]*v[i]
    vy[i+1] = vy[i] + ay[i]*dt
    vx[i+1] = vx[i] + ax[i]*dt
    y[i+1] = y[i] + vy[i]*dt
    x[i+1] = x[i] + vx[i]*dt
    
xanalitico = x[0] + vx[0]*t
yanalitico = y[0] + vy[0]*t - 1/2*g*t**2
                                     
plt.xlabel("x (m)")
plt.ylabel("y (m)")
plt.plot(x, y, label="Euler com resistência")
plt.plot(xanalitico, yanalitico, label="Analítico sem resistência")
plt.legend()


xMax = max(x)
idx = x.argmax()
tMax = t[idx]

for i in range(n):
    if y[i]*y[i-1] < 0:
        alcance = x[i]
        talc = t[i]
print("O alcance da bola foi {:.2f}m e demorou {:.2f}s até o atingir.".format(alcance, talc))



plt.show()