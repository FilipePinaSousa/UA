import numpy as np
from matplotlib import pyplot as plt

def oscQuartFA_1D(x0, v0, k, m, t, b, F0, w_f, alpha, n, dt):
    # Oscilador Quártico sujeito a força e amortecimento
    x = np.empty(n + 1)
    v = np.empty(n + 1)
    a = np.empty(n + 1)
    x[0] = x0
    v[0] = v0
    for i in range(n):
        a[i] = (-k / m * x[i] * (1 + 2 * alpha * x[i] ** 2) - b * v[i] + F0 * np.cos(w_f * t[i])) / m
        v[i + 1] = v[i] + a[i] * dt
        x[i + 1] = x[i] + v[i + 1] * dt
    return x, v, a

m = 1.0                  # massa
x_eq = 0.0               # posição de equilíbrio
k = 1.0                  # constante elástica
b = 0.05                 # coeficiente de amortecimento
alpha = 0.002            # coeficiente de não linearidade
F0 = 7.5                 # amplitude da força
w_f = 1.0                # frequência da força
v0 = 0.0                 # velocidade inicial
x0 = 4.0                 # posição inicial

tf = 200.0               # tempo final
dt = 0.01                # passo de tempo
n = int(tf / dt)         # número de passos
t = np.linspace(0, tf, n + 1)  # vetor de tempo

results = oscQuartFA_1D(x0, v0, k, m, t, b, F0, w_f, alpha, n, dt)  # chamada da função
x = results[0]  # posição

plt.plot(t, x, label="x(t)")  # plot
plt.xlabel("t (s)")
plt.ylabel("x (m)")
plt.grid()
plt.legend()
plt.show()
