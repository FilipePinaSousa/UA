import numpy as np
from matplotlib import pyplot as plt

def oscQuartFA_1D(x0, v0, k, m, t, b, F0, w_f, alpha, n, dt):
    # Oscilador Quártico sujeito a forçado e amortecido
    x = np.empty(n+1)
    v = np.empty(n+1)
    a = np.empty(n+1)
    x[0] = x0
    v[0] = v0
    for i in range(n):
        a[i] = (-k/m*x[i]*(1+2*alpha*x[i]**2) + (-b*v[i]+F0*np.cos(w_f*t[i]))/m)
        v[i+1] = v[i] + a[i]*dt
        x[i+1] = x[i] + v[i+1]*dt
    return x, v, a

m = 1           # massa
x_eq = 0            # equilíbrio
k = 1           # constante elástica
b = 0.05        # coeficiente de amortecimento
alpha = 0.002    # coeficiente de não linearidade
F0 = 7.5            # amplitude da força
w_f = 1.0       # frequência da força
v0 = -4         # velocidade inicial
x0 = -2         # posição inicial

tf = 200        # tempo final
dt = 0.01       # passo de tempo
n = int(tf/dt)      # número de passos
t = np.linspace(0, tf, n+1)     # vetor tempo

results = oscQuartFA_1D(x0, v0, k, m, t, b, F0, w_f, alpha, n, dt)      # chamada da função
x = results[0]      # posição
v = results[1]      # velocidade
a = results[2]      # aceleração

# Cálculo das energias
Epot = 0.5 * k * x**2                 # Energia potencial
Ecin = 0.5 * m * v**2                 # Energia cinética
Etotal = Epot + Ecin                  # Energia mecânica total

# Verificação da constância da energia mecânica
is_constant = np.allclose(Etotal, Etotal[0])  # Verifica se todas as energias mecânicas são aproximadamente iguais

# Plot das energias
plt.plot(t, Epot, label="Epot")
plt.plot(t, Ecin, label="Ecin")
plt.plot(t, Etotal, label="Etotal")
plt.xlabel("t (s)")
plt.ylabel("Energia (J)")
plt.grid()
plt.legend()
plt.show()

print("Energia mecânica é constante:", is_constant)

