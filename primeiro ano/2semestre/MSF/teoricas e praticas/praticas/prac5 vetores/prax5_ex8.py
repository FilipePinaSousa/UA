import numpy as np
import matplotlib.pyplot as plt
import sympy as sym


w=[0,0,10]
v=[0,1,0]
w_v= np.cross(w,v)             #produto vetorial de dois vetores w x v
r=0.11
p_ar=1.225
A = np.pi * r**2

print(w_v)
F_magnus = 0.5 * A *p_ar * r * w_v 
print(F_magnus)
