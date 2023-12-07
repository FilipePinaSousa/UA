import matplotlib.pyplot as plt
import numpy as np

T = [200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0, 1000.0, 1100.0]
E = [0.6950, 4.363, 15.53, 38.74, 75.08, 125.2, 257.9, 344.1, 557.4, 690.7]

# a) ---------------------------------------------------
plt.plot(T,E,"o")
plt.xlabel("Temperatura (K)")
plt.ylabel("Energia (J)")
plt.show()
# Não, a relação entre a energia emitida e a temperatura não é linear. 

# b) -----------------------------------------------------
logT = np.log(T)
logE = np.log(E)
# np.log() é o ln (base e). # np.log10() é o log na base 10.

# log x log: Relação original: y = b * t^m
# log x t : Relação original: y = y0 * e^mt

plt.plot(logT,logE,"o")
m = np.polyfit(logT,logE,1)[0]
b = np.polyfit(logT,logE,1)[1]
x = np.linspace(min(logT)*0.9,max(logT)*1.1,1000)
plt.plot(x,m*x+b)
plt.xlabel("logT (K)")
plt.ylabel("logE (J)")
plt.show()