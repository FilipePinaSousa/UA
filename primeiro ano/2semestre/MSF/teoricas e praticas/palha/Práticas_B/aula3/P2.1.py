import matplotlib.pyplot as plt
import numpy as np

velA = 19.44
aPat = 2
a = 2
t = np.linspace(0,20,1000)

# a)------------------------------------------------------------
plt.plot(t,velA*t) # gráfico de A
plt.plot(t, (a*t**2)/2) # gráfico da Patrulha


# b)------------------------------------------------------------
tintersect = 2*velA/a
print(tintersect)
xintersect = velA * tintersect
print(xintersect)

plt.show()