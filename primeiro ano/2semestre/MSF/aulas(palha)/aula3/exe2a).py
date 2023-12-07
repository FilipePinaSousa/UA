import numpy as np
import matplotlib.pyplot as plt
import sympy as sy 



t,yt,vt,at =sy.symbols("tyt")

vt = 6.80 
g = 9.8

tempo = np.linspace(0,4,100)   
   
yt =((vt**2)/g) * sy.log(sy.cosh(g*t/vt))

vplot = sy.lambdify(t,vt,"numpy")
yplot = sy.lambdify(t,yt,"numpy")
aplot = sy.lambdify(t,at,"numpy")
vt = sy.diff(yt,t)  #derivada
at = sy.diff(vt,t)
plt.plot(t,yt)
plt.show()