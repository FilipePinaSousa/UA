import numpy as np
import matplotlib.pyplot as plt
import sympy as sym

m = 1
t = sym.Symbol("t")

r = [2*t,t**2]
dx = sym.Derivative(r[0], t, evaluate=True)
dy = sym.Derivative(r[1], t, evaluate=True)
d_simpx = sym.simplify(dx)
d_simpy = sym.simplify(dy)

print("Lei da velocidade (",d_simpx,", ",d_simpy,")")     #(2,2*t)

t1 = [2,2]
t2 = [2,4]
t3 = [2,6]
t4 = [2,8]

plt.arrow(0,0,t4[0],t4[1],color='r',width=0.1)
plt.arrow(0,0,t2[0],t2[1],color='b',width=0.1)
plt.show()

