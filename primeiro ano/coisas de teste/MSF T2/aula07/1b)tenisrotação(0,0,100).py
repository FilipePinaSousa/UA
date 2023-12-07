import numpy as np
import matplotlib.pyplot as plt

# Valores dados
g = 9.8
m = 0.057
# Nota: O valor dado é o do diâmetro mas as fórmulas utilizam o raio,
# logo precisamos de dividir o valor por 2 para obter o raio.
r = 0.067 / 2
p_ar = 1.225
# Convert angle from degrees to radians
angle = 10 / 180 * np.pi
# Converter as velocidades de km/h para m/s
vT = 100 * (1000/3600)
v0Norm = 130 * (1000/3600)

# Valores calculados
A = np.pi * r**2
D = g / vT**2
# Cálculo dos componentes da velocidade, o ângulo de 10° é com o eixo OX positivo na
# horizontal e como OY é o eixo vertical, isto quer dizer que a velocidade em z é nula.
v0x = np.cos(angle) * v0Norm
v0y = np.sin(angle) * v0Norm

# Parâmetros
dt = 0.001
t0 = 0
tf = 2
x0 = np.array([-10, 1, 0])
v0 = np.array([v0x, v0y, 0])

# Esta função calcula a aceleração a partir da rotação da bola e da velocidade atual
def accel(w, v):
    vNorm = np.linalg.norm(v)
    # Cálculo da aceleração da resistência do ar
    aXRes = -D * vNorm * v[0]
    aYRes = -D * vNorm * v[1]
    aZRes = -D * vNorm * v[2]
    
    # Cálculo da força de Magnus, np.cross calcula o produto
    # vetorial de dois vetores.
    F_magnus = 1/2 * A * p_ar * r * np.cross(w, v)
    # Finalmente a aceleração é a soma da aceleração gravítica
    # e a soma da aceleração da força de Magnus
    return np.array([aXRes, -g + aYRes, aZRes]) + F_magnus/m

# Número de passos/iterações
#
# + 0.1 para garantir que não há arrendodamentos
# para baixo
n = int((tf-t0) / dt + 0.1)
# Agora lidamos com movimento tridimensional, logo precisamos de mais um
# elemento para os vetores das quantidades.
shape = (n + 1, 3)

w = np.array([0, 0, 100])

tRotPos = np.zeros(n + 1)
xRotPos = np.zeros(shape)
vRotPos = np.zeros(shape)
aRotPos = np.zeros(shape)

# Insert initial values
aRotPos[0] = accel(w, v0)
vRotPos[0] = v0
tRotPos[0] = t0
xRotPos[0] = x0

for i in range(n):
    aRotPos[i + 1] = accel(w, vRotPos[i])
    vRotPos[i + 1] = vRotPos[i] + aRotPos[i] * dt
    xRotPos[i + 1] = xRotPos[i] + vRotPos[i] * dt
    tRotPos[i + 1] = tRotPos[i] + dt
plt.plot(xRotPos[:, 0], xRotPos[:, 1])
plt.xlabel("x(t) (m)")
plt.xlabel("y(t) (m)")
plt.title("Trajetória XoY")
plt.show()

# np.argmax devolve o indíce do máximo no array
idx = xRotPos[:, 1].argmax()
yRotPosMax = xRotPos[idx, 1]
tRotPosMax = tRotPos[idx]

print("yMax = ", yRotPosMax,"m")
print("tMax = ", tRotPosMax, "s")

for i in range(n):
    if xRotPos[i, 1] * xRotPos[i + 1, 1] < 0:
        idx = i
        break

xRotPosRange = xRotPos[idx, 0]
tRotPosRange = tRotPos[idx]

print("xRange = ", xRotPosRange, "m")
print("tRange = ", tRotPosRange, "s")