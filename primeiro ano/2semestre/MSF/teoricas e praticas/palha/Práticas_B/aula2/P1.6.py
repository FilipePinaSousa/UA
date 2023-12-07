import matplotlib.pyplot as plt
import numpy as np

# a) ---------------------------------------------
d = [0.00, 0.735, 1.363, 1.739, 2.805, 3.814, 4.458, 4.955, 5.666, 6.329]
t = [0.00, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00]
plt.plot(t, d, "o")
plt.show()


# c.a.
assert len(d) == len(t)
n = len(d)
x = sum(t)
y = sum(d)
xy = sum(t[i] * d[i] for i in range (n))
xx = sum(t[i]**2 for i in range(n))
yy = sum(d[i]**2 for i in range(n))

# b) ---------------------------------------------
m = (n * xy - x * y)/(n * xx - x**2)    # declive
b = (xx * y - x * xy)/(n * xx - x**2)   # ordenada
r2 = (((n*xy)-(x*y))**2)/(((n*xx)-(x**2))*((n*yy)-(y**2)))  # coeficiente de determinação
deltaM = abs(m) * np.sqrt( ((1/r2)-1)/(n-2) )   # erro do declive
deltaB = deltaM * np.sqrt(xx/n)     # erro da ordenada
print("x = ", x)
print("y = ", y)
print("xy = ", xy)
print("yy = ", yy)
print("m = ", m)
print("b = ", b)
print("r2 = ", r2)
print("deltaM = ", deltaM)
print("deltaB = ", deltaB)

# Sim, pelo coeficiente de determinação r = 0.994, é uma relação linear bem aproximada.

plt.plot(t, d, "o")
eixox = np.linspace(0.0, 9.0 * 1.1, 10000) # determina eixo das abcissas (separado em 1000 espaços iguais)
plt.plot(eixox, m*eixox + b)
plt.show()


# c) ---------------------------------------------
print(sum(d))
print("Velocidade média =", m, "+-", deltaM, "km/min")

# d) --------------------------------------------- 
m2 = np.polyfit(t, d, 1)[0]
b2 = np.polyfit(t, d, 1)[1]
print("m (vel média) com polyfit = ", m2, "\nb com polyfit", b2) # polinomio de grau 1 (regressão linear)
plt.plot(t, d, "o")
plt.plot(eixox, m2*eixox + b2)
plt.show()
# m2 e b2 resultam nos mesmos valores de m e b anteriormente calculados

# e) ---------------------------------------------
v = 60 * m
print("A velocidade média em Km/h é: ", v, "km/h")