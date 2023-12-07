import matplotlib.pyplot as plt
import numpy as np

v0 = 10
g = 9.8

# b)

t = v0/g
print("tempo hmax:", t)

hMax = v0*t - (g*t**2)/2
print("altura max:", hMax) 

# c)

tPos0 = 2*v0/g
print("tempo posicção inicial (solo)", tPos0)

taxis = np.linspace(0,2.1,10000)
plt.plot(taxis,v0*taxis - (g*taxis**2)/2)
plt.show()
