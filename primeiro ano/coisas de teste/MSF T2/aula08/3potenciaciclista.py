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

#a)
v = (30 * 1000) / 3600

forca_res = C_res/2 * A * rho_ar * v**2
forca_atrito = + mu * g * m

potencia = (forca_res + forca_atrito) * v
print("Potencia = " ,potencia, "W")

#b)
v = (40 * 1000) / 3600

forca_res = C_res/2 * A * rho_ar * v**2
forca_atrito = + mu * g * m

potencia = (forca_res + forca_atrito) * v
print("Potencia = ", potencia,"W")