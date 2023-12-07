import numpy as np
import matplotlib.pyplot as plt
import sympy as sym

v_t=6.8
g=9.8
t=np.linspace(0,4)

y=((v_t**2)/g)*np.log(np.cosh(g*t/v_t))

plt.xlabel("Tempo (s)")
plt.ylabel("Distância percorrida (m)")
plt.plot(t,y)
plt.show()