import numpy as np
import matplotlib.pyplot as plt

g = 9.8

# Convert velocity from km/h to m/s
vNorm = 100 * (1000 / 3600)
# Convert angle from degrees to radians
angle = 10 / 180 * np.pi

vXinitial = np.cos(angle) * vNorm
vYinitial = np.sin(angle) * vNorm

# Parâmetros
dt = 0.01
t0 = 0
tf = 1.2

# Agrupamos os valores de x e y em arrays para representar as quantidades
x0 = np.array([0, 0])
v0 = np.array([vXinitial, vYinitial])

# Número de passos/iterações
n = int((tf-t0) / dt + 0.1)

# O tamanho dos arrays para serem criados, como este tuple tem dois valores
# um array com `n + 1` de arrays bidimensionais
shape = (n + 1, 2)

tRes = np.zeros(n + 1)
xRes = np.zeros(shape)
vRes = np.zeros(shape)
aRes = np.zeros(shape)

# O tempo continua a ser unidimensional
t = np.zeros(n + 1)
# Todas as outras quantidades passam a 2D
x = np.zeros(shape)
v = np.zeros(shape)
a = np.zeros(shape)

# Insert initial values
aRes[0] = np.array([0, -g])
vRes[0] = v0
tRes[0] = t0
xRes[0] = x0

for i in range(n):
    vNorm = np.linalg.norm(vRes[i])
    # Cálculo da aceleração da resistência do ar
    aXRes = -0.5 * vNorm**2 * 0.4 * 1.2 * 0.01
    aYRes = -g - 0.5 * vNorm**2 * 0.4 * 1.2 * 0.01

    aRes[i + 1] = np.array([aXRes, aYRes])
    vRes[i + 1] = vRes[i] + aRes[i] * dt
    xRes[i + 1] = xRes[i] + vRes[i] * dt
    tRes[i + 1] = tRes[i] + dt

# Utilizamos a notação [:, i] para extrair o primeiro elemento de todos
# os vetores num array.
plt.plot(x[:, 0], x[:, 1], label="Sem resistência", color='cyan', linestyle='--')
plt.plot(xRes[:, 0], xRes[:, 1], label="Com resistência", color='red', linestyle='--')

plt.xlabel("x(t) (m)")
plt.ylabel("y(t) (m)")
plt.legend(loc="upper left")
plt.title("Trajetória")
plt.show()

# Imprime o alcance máximo e a altura máxima

print("O alcance máximo sem resistência foi de", x[-1, 0], "m")
print("A altura máxima sem resistência foi de", x[:, 1].max(), "m")

print("O alcance máximo com resistência foi de", xRes[-1, 0], "m")
print("A altura máxima com resistência foi de", xRes[:, 1].max(), "m")
