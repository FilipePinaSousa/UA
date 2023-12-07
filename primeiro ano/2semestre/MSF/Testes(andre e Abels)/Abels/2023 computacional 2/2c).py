import numpy as np
import matplotlib.pyplot as plt

g = 9.8 

mu = 0.04 
rho_ar = 1.225 
A = 2
m = 2000 
C_res = 0.25


p = 40000

v = 1

forca_res = C_res/2 * A * rho_ar * v**2
forca_atrito = + mu * g * m

potencia = (forca_res + forca_atrito) * v
print("Potencia = " ,potencia, "W")
trabalho = potencia * 2000**2
print("trabalho realizado = ", trabalho,"J")
