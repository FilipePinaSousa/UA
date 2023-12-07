import numpy as np

# Parâmetros do oscilador
m = 1 # kg
k = 1 # N/m
xeq = 2 # m

# Função para calcular a energia potencial
def potential_energy(x):
    return 0.5*k*(np.abs(x) - xeq)**2

# Função para calcular a amplitude e a frequência do movimento
def motion(E):
    # Energia potencial máxima
    Ep_max = E - 0.5*m*(np.sqrt(2*E/k))**2
    # Amplitude
    A = np.sqrt(2*Ep_max/k)
    # Frequência
    f = 1/(2*np.pi)*np.sqrt(k/m)
    return A, f
# Energia mecânica de 1 J
E = 1
A, f = motion(E)
print(f"Energia mecânica = {E:.2f} J")
print(f"Amplitude = {A:.2f} m")
print(f"Frequência = {f:.2f} Hz")

# Energia mecânica de 0.75 J
E = 0.75
A, f = motion(E)
print(f"Energia mecânica = {E:.2f} J")
print(f"Amplitude = {A:.2f} m")
print(f"Frequência = {f:.2f} Hz")

# Energia mecânica de 1.5 J
E = 1.5
A, f = motion(E)
print(f"Energia mecânica = {E:.2f} J")
print(f"Amplitude = {A:.2f} m")
print(f"Frequência = {f:.2f} Hz")







# Energia potencial máxima
Ep_max = E - 0.5*m*(np.sqrt(2*E/k))**2

# Amplitude
A = np.sqrt(2*Ep_max/k) - xeq

# Frequência
f = 1/(2*np.pi)*np.sqrt(k/m)

print(f"Amplitude = {A:.2f} m")
print(f"Frequência = {f:.2f} Hz")






# Energia total de 1.5 J
E = 1.5

# Energia potencial máxima
Ep_max = E - 0.5*m*(np.sqrt(2*E/k))**2

# Amplitude
A = np.sqrt(2*Ep_max/k) - xeq

# Frequência
f = 1/(2*np.pi)*np.sqrt(k/m)

print(f"Amplitude = {A:.2f} m")
print(f"Frequência = {f:.2f} Hz")