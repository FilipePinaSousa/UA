import matplotlib.pyplot as plt
import numpy as np
'''
7. Uma mola exerce uma força 𝐹𝑥 = −𝑘 𝑥 𝑡 , em que 𝑘 é a constante elástica da mola, num corpo de massa 𝑚.
Considere 𝑘 = 1 N/m e 𝑚 = 1 kg.
a) Calcule numericamente a lei do movimento, no caso em que a velocidade inicial é nula e a posição inicial 4 m.
b) Calcule a amplitude do movimento e o seu período, usando os resultados numéricos.
c) Calcule a energia mecânica. É constante ao longo do tempo?
Oscilador Forçado e amortecido
d) Ao oscilador está aplicada uma força exterior
𝐹𝑥
𝑒𝑥𝑡 = 𝐹0 cos 𝜔𝑓𝑡
e uma força de amortecimento
𝐹𝑥
𝑎𝑚𝑜𝑟𝑡 = −𝑏𝑣𝑥
em que
𝑏 = 0.01 kg/s
𝐹0 = 2 N
𝜔𝑓 = 1 rad/s

'''
# d) Ao oscilador está aplicada uma força exterior

t0 = 0.0
tf = 900
dt = 0.001
n = int((tf-t0)/dt)
k = 1
m = 1
x0 = 4
v0 = 0
b = 0.01
f0 = 2
wf = 1  # frequencia força externa


t = np.zeros(n+1)
x = np.zeros(n+1)
vx = np.zeros(n+1)
ax = np.zeros(n+1)
emec = np.zeros(n+1)

x[0] = x0
vx[0] = v0


for i in range(n):
    t[i+1] = t[i] + dt
    ax[i] = (-k*x[i]-b*vx[i]+f0*np.cos(wf*t[i]))/m
    vx[i+1] = vx[i] + ax[i] * dt
    x[i+1] = x[i] + vx[i+1] * dt  
    emec[i] = 0.5*m*vx[i]**2 + 0.5*k*x[i]**2   # Emec = Ec + EpotElastica


plt.title("Posição x tempo")
plt.plot(t,x)
plt.show()

plt.title("Velocidade x tempo")
plt.plot(t,vx)
plt.show()

plt.title("Energia mecância x tempo")
plt.plot(t,emec)
plt.show()