from numpy import linalg as la
import numpy as np

k = 0
kl = 0.5  # -> k'
m = 1

# w = valores propios;  v = vetores próprios
w, v = la.eig([[(k+kl)/m, -kl/m, 0],
               [-kl/m, 2*kl/m, -kl/m],
               [0, -kl/m, (k+kl)/m]])

print("Valores prórpios")
print(w)
print("Frequências:")
print(np.sqrt(w))

print("Vetores prórpios:")
print(v)   # são ortogonais entre si (produto escalar é nulo) -> formam uma base

print((int)(v[0][0]*v[1][0] + v[0][1]*v[1][1] + v[0][2]*v[1][2]))  # prod escalar do primeiro vetor com o segundo = 0