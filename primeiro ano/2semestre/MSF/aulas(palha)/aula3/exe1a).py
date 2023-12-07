import numpy as np
import matplotlib.pyplot as plt
import sympy as sy
t = np.linspace(0,25,100)
va = 70/3.6
plt.plot(t,va*t)
plt.plot(t,t**2)

plt.xlabel("tempo")
plt.ylabel("posição")

plt.plot(va,va*va,"o") #interseção e tabela
plt.show()