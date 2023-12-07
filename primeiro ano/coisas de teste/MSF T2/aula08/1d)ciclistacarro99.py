import numpy as np
import matplotlib.pyplot as plt

g = 9.8 # Aceleração gravítica na terra

mu = 0.004 # Coeficiente de resistência do alcatrão
rho_ar = 1.225 # Densidade do ar
A = 0.3 # Área frontal do ciclista-bicicleta
m = 75 # Massa do ciclista-bicicleta
C_res = 0.9 # Coeficiente de resistência do ar

# A unidade SI de potência é o watt, logo precisamos de
# converter de cavalos para watts
p_ciclista = 0.4 * 735.49875

# Parâmetros
dt = 0.001
t0 = 0
tf = 200
x0 = 0
v0 = 1

# Esta função calcula a aceleração a partir da velocidade atual do ciclista
def accel(v):
    # Aceleração pela potência do ciclista
    accel_p = p_ciclista/(m * v)
    # Aceleração pela resistência do ar
    # Multiplicar por (1 - 0.99) = 0.01 pois a força está atenuada
    accel_res = -C_res/(2*m) * A * rho_ar * v**2 * 0.01
    # Aceleração pelo atrito
    accel_atrito = - mu * g
    # Aceleração total
    return accel_p + accel_res + accel_atrito

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
idx = v.argmax()
vT99 = v[idx]

print("VT = ", vT99, "m/s")