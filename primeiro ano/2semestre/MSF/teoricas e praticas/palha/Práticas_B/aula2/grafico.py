import matplotlib.pyplot as plt 
import numpy as np


t = np.linspace(0,2,100)
g = 9.8
vt = 6.8

plt.plot(t, vt**2/g * np.log(np.cosh(g*t/vt)))
plt.show()
