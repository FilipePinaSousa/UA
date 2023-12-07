import matplotlib.pyplot as plt
import numpy as np

""" 11. Um corpo de massa 1 kg move-se num oscilador duplo, com dois pontos de equilíbrio, Xeq = 1.5 m. 
O oscilador tem a energia potencial 
Ep = 1/2 * k * (x^2-xeq^2)^2
exerce no corpo a força
Fx = 2k * (x^2-xeq^2) * x
onde k = 1 N/m. 
c) Calcule a lei do movimento quando a energia total for 3.0 J. Qual a amplitude e a frequência do movimento? """

t0 = 0.0
tf = 20
dt = 0.01
n = int((tf-t0)/dt)
k = 1
m = 1
xeq = 1.5

t = np.zeros(n+1)
x = np.zeros(n+1)
vx = np.zeros(n+1)
#ax = np.zeros(n+1)

x[0] = 2.168
vx[0] = 0

for i in range(n):
    t[i+1] = t[i] + dt
    ax = -(2*k*(x[i]**2-xeq**2)*x[i])/m
    vx[i+1] = vx[i] + ax * dt
    x[i+1] = x[i] + vx[i+1] * dt

#ax[i+1] = (2*k*(x[i+1]**2-xeq**2)*x[i+1])/m
plt.title("Posição x tempo")
plt.plot(t,x)
plt.show()

for i in range(n):
    if( np.abs(x[i]-np.max(x)) <0.0001): 
        print(t[i]) # imprime os tempos nos quais são atingidos o valor máximo de X
# O período é a diferença entre quaisquer um desses tempos impressos, portanto T = 5.42s

print("Amplitude: ", np.max(x)) # A = 2.168m
