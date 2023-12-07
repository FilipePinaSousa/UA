import matplotlib.pyplot as plt
import sympy as sp


t=sp.Symbol('t', real=True, positive=True)
g=sp.Symbol('g', real=True, positive=True)
vt=sp.Symbol('vt', real=True, positive=True)
y=sp.Symbol('y', real=True, positive=True)
velInst=sp.Symbol('velInst', real=True, positive=True)
aInst=sp.Symbol('aInst', real=True, positive=True)


y = (vt**2/g) * sp.log(sp.cosh(g*t/vt))
velInst = sp.diff(y,t)
print(velInst)

velInst = vt*sp.tanh(g*t/vt)
aInst = sp.diff(velInst,t)
print(aInst)