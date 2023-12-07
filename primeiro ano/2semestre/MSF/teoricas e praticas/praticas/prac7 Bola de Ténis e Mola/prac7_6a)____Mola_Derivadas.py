import numpy as np
import matplotlib.pyplot as plt
import sympy as sym

A = sym.Symbol("A")
w = sym.Symbol("w")
t = sym.Symbol("t")
o = sym.Symbol("o")

v = sym.Derivative(A*sym.cos(w*t+o), t, evaluate=True)
v_simp = sym.simplify(v)

print(v_simp)       # v(t) = -A*w*sin(o + t*w)