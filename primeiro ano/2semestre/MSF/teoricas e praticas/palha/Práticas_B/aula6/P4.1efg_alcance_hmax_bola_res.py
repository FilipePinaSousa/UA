import matplotlib.pyplot as plt
import numpy as np

# problema 1 cap 4 alíneas e, f, g
""" 1. Uma bola de futebol é chutada com velocidade de 100 km/h, a fazer um ângulo de 10º com o campo (horizontal).
e) Considere agora a resistência do ar. A força de resistência do ar ao movimento da bola é:
Fxres = -m*D*abs(v)*vx
Fyres = -m*D*abs(v)*vy
em que D = g/vt**2 e a velocidade terminal é vT = 100 km/h. Atualize o seu programa de modo a considerar a 
força de resistência do ar. Faça o gráfico da altura em função da distância percorrida na horizontal.
f) Nas condições da alínea e), determine qual a altura máxima atingida pela bola e em que instante? Tem confiança 
no seu resultado?
g) Nas condições da alínea e), qual o alcance (distância entre a posição onde foi chutada e o ponto onde alcançou no 
campo) da trajetória da bola e quanto tempo demorou? Tem confiança no seu resultado?
 """
# com resitencia do ar


g = 9.80
vt = 100/3.6
t0 = 0.0
tf = 1
dt = 0.001
n = int((tf-t0)/dt+0.1)
teta = np.pi/18
v0 = 100/3.6
v0x = np.cos(teta) * v0
v0y = np.sin(teta) * v0
x0 = 0
y0 = 0
dres = g/vt**2   #  D = g/vt**2

t = np.zeros(n+1)
ay = np.zeros(n+1)
ax = np.zeros(n+1)
vy = np.zeros(n+1)
vx = np.zeros(n+1)
y = np.zeros(n+1)
x = np.zeros(n+1)

t[0] = t0
vy[0] = v0y
vx[0] = v0x
y[0] = y0
x[0] = x0


for i in range(n):
    t[i+1] = t[i] + dt
    vv = np.sqrt(vx[i]**2 + vy[i]**2)
    ax[i] = -dres*vv*vx[i]
    ay[i]= -g-dres*vv*vy[i]
    vx[i+1] = vx[i] + ax[i] * dt
    vy[i+1] = vy[i] + ay[i] * dt
    x[i+1] = x[i] + vx[i] * dt
    y[i+1] = y[i] + vy[i] * dt


plt.plot(x,y)
plt.show()


for i in range(n):
    if y[i] == max(y):
        tymaxEuler = t[i]

# resultados
print("Altura máxima (método de Euler): ", max(y))
print("Tempo que atinge altura máxima (método de Euler):", tymaxEuler)

for i in range(n):
    if y[i] < 0.01 and y[i] > -0.01 and t[i]>0.1:
        print("Alcance máximo (método de Euler):", x[i], "Tempo em que atinge esse alcance", t[i])
