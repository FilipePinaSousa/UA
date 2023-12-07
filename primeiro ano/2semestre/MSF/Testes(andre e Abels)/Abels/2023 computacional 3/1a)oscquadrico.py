import numpy as np
import matplotlib.pyplot as plt

m = 1
xeq = 0
k = 1
alpha = 0.05
beta = 0

x = np.arange(-8, 4, 0.1)
Ep = 0.5*k*(x**2)+alpha*(x**3)

plt.plot(x,Ep)
plt.grid()
plt.title("Diagrama de Energia")
plt.ylabel("Energia Potencial(J)")
plt.xlabel("x(m)")
plt.show()
