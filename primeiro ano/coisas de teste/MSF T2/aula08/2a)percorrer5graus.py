import numpy as np
import matplotlib.pyplot as plt

# Parâmetros
dt = 0.001
t0 = 0
tf = 500
x0 = 0
v0 = 1

g = 9.8

p_ciclista = 0.4 * 735.49875
mu = 0.004 # Coeficiente de resistência do alcatrão
rho_ar = 1.225 # Densidade do ar
A = 0.3 # Área frontal do ciclista-bicicleta
m = 75 # Massa do ciclista-bicicleta
C_res = 0.9 # Coeficiente de resistência do ar

# Inclinação em radianos
incl = np.radians(5)

# Esta função calcula a aceleração a partir da velocidade atual do ciclista
def accel(v):
    # Aceleração pela potência do ciclista
    accel_p = p_ciclista/(m * v)
    # Aceleração pela resistência do ar
    accel_res = -C_res/(2*m) * A * rho_ar * v**2
    # Aceleração pelo atrito
    accel_atrito = - mu * np.cos(incl) * g
    # Aceleração pelo peso
    accel_peso = - np.sin(incl) * g
    # Aceleração total
    return accel_p + accel_res + accel_atrito + accel_peso

# Número de passos/iterações
#
# + 0.1 para garantir que não há arrendodamentos
# para baixo
n = int((tf-t0) / dt + 0.1)

t = np.zeros(n + 1)
x = np.zeros(n + 1)
v = np.zeros(n + 1)
a = np.zeros(n + 1)

# Valores iniciais
a[0] = accel(v0)
v[0] = v0
x[0] = x0
t[0] = t0

for i in range(n):
    a[i + 1] = accel(v[i])
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i] * dt
    t[i + 1] = t[i] + dt

plt.plot(t, x - 2000, "r")
plt.xlabel("t (s)")
plt.ylabel("x (m)")
plt.title("Posição")
plt.show()

for i in range(n):
  # Subtrair 2km a posição
  scaledX0 = x[i] - 2000
  scaledX1 = x[i + 1] - 2000
  # Procurar os zeros com a posição modificada
  if scaledX0 == 0 or scaledX0 * scaledX1 < 0:
    idx = i
    break

x2000 = x[idx]
t2000 = t[idx]

print("X2000 = ", x2000, "m")
print("t2000 = ", t2000, "s")