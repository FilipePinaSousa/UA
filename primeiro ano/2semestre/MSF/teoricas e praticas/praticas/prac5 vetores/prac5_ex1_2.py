import numpy as np
import math as math

v = [3,4]

int_v = math.sqrt(v[0]**2+v[1]**2)           #módulo
v_unitario = [v[0]/int_v,v[1]/int_v]         #vetor unitario
u = 2*v

r=[1,2]
p=[-2,3]

prod_vet = r[0]*p[0] + r[1]*p[1]


print("1a) - Módulo do vetor v =  ",int_v)
print("1b) - Vetor unitário de v = ",v_unitario)
print("1c) - Vetor u = ",v)
print("2 - Produto vetorial = ",prod_vet)


