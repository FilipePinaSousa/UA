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

# Rotação nula
w = np.array([0, 0, 0])

t = np.zeros(n + 1)
x = np.zeros(shape)
v = np.zeros(shape)
a = np.zeros(shape)

# Insert initial values
a[0] = accel(w, v0)
v[0] = v0
t[0] = t0
x[0] = x0

for i in range(n):
    a[i + 1] = accel(w, v[i])
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i] * dt
    t[i + 1] = t[i] + dt
plt.plot(x[:, 0], x[:, 1])
plt.xlabel("x(t) (m)")
plt.xlabel("y(t) (m)")
plt.title("Trajetória XoY")
plt.show()

# np.argmax devolve o indíce do máximo no array
idx = x[:, 1].argmax()
yMax = x[idx, 1]
tMax = t[idx]

print("yMax = ", yMax,"m")
print("tMax = ", tMax, "s")

for i in range(n):
    if x[i, 1] * x[i + 1, 1] < 0:
        idx = i
        break

xRange = x[idx, 0]
tRange = t[idx]

print("xRange = ", xRange, "m")
print("tRange = ", tRange, "s")