import numpy as np
import matplotlib.pyplot as plt
import sympy as sym

tempo = np.linspace(0, 4)

vT = sym.Symbol("vT")
g = sym.Symbol("g")
t = sym.Symbol("t")

d = sym.Derivative((vT**2)/g * sym.log(sym.cosh(g*t/vT)), t, evaluate=True)
d_simp = sym.simplify(d)

d2 = sym.Derivative(d_simp, t, evaluate=True)
d2_simp = sym.simplify(d2)

print("a(t) = ",d2_simp)

plt.xlabel("Tempo (s)")
plt.ylabel("Aceleração (m/s**2)")
plt.plot(tempo, 9.8/(np.cosh(9.8*tempo/6.80)**2))
plt.show()