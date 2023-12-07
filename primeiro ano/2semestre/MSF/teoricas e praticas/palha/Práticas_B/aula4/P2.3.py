import matplotlib.pyplot as plt
import numpy as np

g = 9.80
t0 = 0.0
tf = 4.0
dt = 0.01
n = int((tf-t0)/dt+0.1)
v0 = 0.0
v0y = 0
y0 = 0

t = np.zeros(n+1)
vy = np.zeros(n+1)
y = np.zeros(n+1)

t[0] = t0
vy[0] = v0y
y[0] = y0

for i in range(n):
    t[i+1] = t[i] + dt
    vy[i+1] = vy[i] + g * dt
    y[i+1] = y[i] + vy[i] * dt

for i in range(n): # descobrir o valor aprox de v em t = 3s
    if t[i+1] > 3-2*dt and t[i+1] < 3+2*dt:
        print('dt, t, vy= ',dt,t[i+1], vy[i+1])
        
print()

for i in range(n): # descobrir o valor aprox de y em t = 2s
    if t[i+1] > 2-2*dt and t[i+1] < 2+2*dt:  # t[i+1] pq o array de t vai de 0 até n+1
        print('dt, t, y= ',dt,t[i+1], y[i+1])

# Velocidade exata (fórmula)
vExact = g * 3
print("vel exata = ", vExact)

# Altura exata (fórmula)
h = g*(2**2)/2
print("altura exata=", h)

dtArr = [0.005, 0.010, 0.050, 0.100, 0.500]
yAprox = [19.55, 19.50, 19.11, 18.62, 14.7] # Array obtida a partir da mudança sucessiva do valor de dt (valores de dtArr)
# e constatação dos resultados de y[]
# Isso foi feito assim pois as duas arrays usadas no gráfico devem possuir a mesma dimensão

yAprox = np.array(yAprox) # Transforma lista em array pra poder subtrair pela constante (altura exata) na chamada do plt.plot()
print(h-yAprox)
plt.plot(dtArr, np.abs(h-yAprox), "o")
m = np.polyfit(dtArr, np.abs(h-yAprox), 1)[0]
b = np.polyfit(dtArr, np.abs(h-yAprox), 1)[1]
x = np.linspace(min(dtArr)*0.9,max(dtArr)*1.1,100000)
plt.plot(x, x*m+b)
plt.show()