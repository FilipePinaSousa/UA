

import math

# Parâmetros do ciclista
m = 75 # kg
mu = 0.004 # coeficiente de resistência do piso
Cres = 0.9 # coeficiente resistência do ar
A1 = 0.30 # área frontal (m^2)
A2 = 2*A1 # área frontal com o tronco levantado (m^2)
rho = 1.225 # densidade do ar (kg/m^3)

# Velocidade em m/s
v = 30/3.6

# Força de resistência do piso
Fr = mu*m*9.81

# Força de resistência do ar com o tronco normal
Fa1 = 0.5*Cres*rho*A1*v**2

# Força de resistência do ar com o tronco levantado
Fa2 = 0.5*Cres*rho*A2*v**2

# Força total com o tronco normal
F1 = Fr + Fa1

# Força total com o tronco levantado
F2 = Fr + Fa2

# Potência com o tronco normal
P1 = F1*v

# Potência com o tronco levantado
P2 = F2*v

print(f"Potência com tronco normal = {P1:.2f} W")
print(f"Potência com o tronco levantado = {P2:.2f} W")
