# Imports
import numpy as np
import matplotlib.pyplot as plt

# Variables
k = 1               # Constante da mola
m = 1               # Massa
b = 0.05            # Coeficiente de amortecimento      
alpha = 0.002       # Coeficiente do termo quártico
f_0 = 7.5           # Amplitude da força externa
omega_f = 1         # Frequência angular da força externa

# Time
time_start, time_end = 0, 500               # Tempo inicial e final
dt = 0.01                                # Passo de tempo               
n = int((time_end - time_start) / dt)       # Número de pontos

# Functions


def potential_energy(r):                                 # Energia potencial             
    return 0.5 * k * r**2 * (1 + alpha * r**2)


def force(r):                                        # Força            
    return -k * r * (1 + 2 * alpha * r**2)


def external_force(t):                            # Força externa                                   
    return f_0 * np.cos(omega_f * t)


def softening_force(r, v):                    # Força de amorteçimento              
    return -b * v


def acceleration(r, v, t):                                                  # Aceleração                                  
    return (external_force(t) + softening_force(r, v) + force(r)) / m


# Non formula functions


def is_local_maximum(array, index):                                         # Verifica se o valor é um máximo local
    return array[index - 1] < array[index] > array[index + 1]


def get_all_local_maxima(array):                                                        # Retorna todos os máximos locais
    maxima = [i for i in range(1, len(array) - 1) if is_local_maximum(array, i)]
    return maxima


def get_period_from_array(r):                                   # Retorna o período
    maxima = get_all_local_maxima(r)
    return (maxima[-1] - maxima[-2]) * dt

# a) Calcule numericamente a lei do movimento, no caso em que a velocidade inicial é nula e a posição inicial 3 m

# Initial conditions
r0 = 3                                          # Posição inicial 
v0 = 0                                        # Velocidade inicial              
a0 = acceleration(r0, v0, time_start)           # Aceleração inicial

# Arrays
a = np.zeros(n)                        # Aceleração
v = np.zeros(n)                   # Velocidade
r = np.zeros(n)             # Posição
t = np.zeros(n)         # Tempo

a[0] = a0                  
v[0] = v0                   
r[0] = r0
t[0] = time_start

# Euler-Cromer method
for i in range(1, n):                                           # Método de Euler-Cromer
    a[i] = acceleration(r[i - 1], v[i - 1], t[i - 1])
    v[i] = v[i - 1] + a[i - 1] * dt
    r[i] = r[i - 1] + v[i] * dt
    t[i] = t[i - 1] + dt


# Graph Position

plt.plot(t, r, label="r(t)")
plt.xlabel("t")
plt.ylabel("r")
plt.legend()
plt.show()

# Graph Velocity

plt.plot(t, v, label="v(t)")
plt.xlabel("t")
plt.ylabel("v")
plt.legend()
plt.show()

#-------------------------------------------------------------------------------------
#
amplitude_idx = get_all_local_maxima(r)[-1]         # Índice do máximo local
amplitude = r[amplitude_idx]                        # Amplitude
print("Amplitude: ", amplitude, "m")                

period = get_period_from_array(r)                   # Período
print("Period: ", period, "s")

def get_fourier_coefficients(t_array, r_array, t_start_idx, t_end_idx, fourier_idx):                # Coeficientes de Fourier
    period = t_array[t_end_idx] - t_array[t_start_idx]  # Periodo                               
    omega = 2 * np.pi / period                    # Frequência angular

    # Calculation of the integral for a_n
    s1 = r_array[t_start_idx] * np.cos(fourier_idx * omega * t_array[t_start_idx])               
    s2 = r_array[t_end_idx] * np.cos(fourier_idx * omega * t_array[t_end_idx])
    st = r_array[t_start_idx + 1 : t_end_idx] * np.cos(
        fourier_idx * omega * t_array[t_start_idx + 1 : t_end_idx]
    )
    sum_st = np.sum(st)
    integral_s = ((s1 + s2) / 2 + sum_st) * dt
    a_n = (2 / period) * integral_s

    # Calculation of the integral for b_n
    q1 = r_array[t_start_idx] * np.sin(fourier_idx * omega * t_array[t_start_idx])
    q2 = r_array[t_end_idx] * np.sin(fourier_idx * omega * t_array[t_end_idx])
    qt = r_array[t_start_idx + 1 : t_end_idx] * np.sin(
        fourier_idx * omega * t_array[t_start_idx + 1 : t_end_idx]
    )
    sum_qt = np.sum(qt)
    integral_q = ((q1 + q2) / 2 + sum_qt) * dt
    b_n = 2 / period * integral_q

    return a_n, b_n

a, b = get_fourier_coefficients(t, r, int(n / 2), n - 1, 1)

print("an: ", a)
print("bn: ", b)