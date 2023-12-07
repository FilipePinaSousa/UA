import numpy as np
from scipy.integrate import solve_ivp
# Parâmetros da bola de tênis
m = 0.057 # kg
r = 0.033 # m
CD = 0.5
A = np.pi*r**2
rho = 1.225 # kg/m^3
g = 9.81 # m/s^2
v_terminal = 100/3.6 # m/s

# Componentes da velocidade inicial
v0 = 100/3.6 # m/s
theta = np.deg2rad(10)
vx0 = v0*np.cos(theta)
vy0 = v0*np.sin(theta)

# Função para calcular a energia mecânica
def energy(t, y):
    y0, y1, y2, y3 = y
    # Energia cinética
    K = 0.5*m*(y2**2 + y3**2)
    # Energia potencial
    U =*g*y1
    # Energia mecânica
    E = K + U
    return E

# Função para calcular a velocidade da bola
def velocity(t, y):
    y0, y1, y2, y3 = y
    # Força de resistência do ar
    Fd = -0.5*rho*A*CD*np.sqrt(y2**2 + y3**2)*y2/m
    # Equações do movimento com resistência do ar
    y2_prime = Fd/m
    y3_prime = -g + Fd/m
    return [y2, y3, y2_prime, y3_prime]

# Função para calcular o trabalho realizado pela força de resistência do ar
def work(t, y):
    y0, y1, y2, y3 = y
    # Força de resistência do ar
    Fd = -0.5*rho*A*CD*np.sqrt(y2**2 + y3**2)*y2/m
    # Trabalho realizado pela força de resistência do ar
    W = Fd*(y1 - 0)
    return W
# Condições iniciais
y0 = [0, 0, vx0, vy0]

# Tempo de integração
t_span = [0, 0.8]

# Número de pontos
n_points = 1000

# Solução das equações diferenciais
sol = solve_ivp(velocity, t_span, y0, t_eval=np.linspace(0, 0.8, n_points))

# Energia mecân
E = energy(sol.t, sol.y)

# Trabalho realizado pela força de resistência do ar
W = np.zeros_like(sol.t)
for i in range(len(sol.t)):
    W[i] = work(sol.t[i], sol.y[:, i])

# Energia mecânica nos instantes t0, t1 e t2
print("Energia mecânica:")
print(f"t0 = {sol.t[0]:.2f} s: {E[0]:.2f} J")
print(f"t1 = {sol.t[int(0.4*n_points)]:.2f} s: {E[int(0.4*n_points)]:.2f} J")
print(f"t2 = {sol.t[int(0.8*n_points)]:.2f} s: {E[int(0.8*n)]:.2f} J")

# Trabalho realizado pela força de resistência do ar nos instantes t0, t1 e t2
print("Trabalho realizado pela força de resistência do ar:")
print(f"t0 = {sol.t[0]:.2f} s: {W[0]:.2f} J")
print(f"t1 = {sol.t[int(0.4*n_points)]:.2f} s: {W[int(0.4*n_points)]:.2f} J")
print(f"t2 = {sol.t[int(0.8*n_points)]:.2f} s: {W[int(0.8*n_points)]:.2f} J")