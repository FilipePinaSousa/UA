import matplotlib.pyplot as plt
import numpy as np
import sympy as sp

vt = 6.80
g = 9.80

t = np.linspace(0.0,4.0,1000)

# a) ---------------------------------------------
y = (vt**2/g) * np.log(np.cosh(g*t/vt))
plt.plot(t, y)
plt.show()

# b) ---------------------------------------------
# symbolic.py ---> vt*sinh(g*t/vt)/cosh(g*t/vt) == vt*tanh(g*t/vt)
vy = vt*np.tanh(g*t/vt)
plt.plot(t,vy)
plt.show()

# c) ---------------------------------------------
# symbolic.py ---> g*(1 - tanh(g*t/vt)**2) == g/cosh(g*t/vt)**2
ay = g/np.cosh(g*t/vt)**2
plt.plot(t,ay)
plt.show()

# d) ---------------------------------------------
ay2 = g - (g/vt**2)*vy*np.abs(vy)
plt.plot(t,ay)
plt.plot(t,ay2,"r--")
plt.show()

# e) ---------------------------------------------
# t = vt/g * arcosh10^(g*y/vt^2)
h = 20
tcres = vt/g * np.arccosh(np.e**(g*h/vt**2))
print("Tempo com resistência do ar: ", tcres, "s")
tsres = np.sqrt(2*h/g)
print("Tempo sem resistência do ar: ", tsres, "s")

#f) ---------------------------------------------
vf = vt*np.tanh(g*tcres/vt)
af = g/np.cosh(g*tcres/vt)**2
print("Velocidade final: ", vf)
print("Aceleração final: ", af) # faz sentindo a aceleração ser 0, pois o movimento passa a ser um movimento uniforme no final (a=0)
