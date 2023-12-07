import matplotlib.pyplot as plt
import numpy as np

""" 11. Um corpo de massa 1 kg move-se num oscilador duplo, com dois pontos de equilíbrio, xeq = 1.5 m. 
O oscilador tem a energia potencial 
Ep = 1/2 * k * (x^2-xeq^2)^2
e exerce no corpo a força
Fx = 2k * (x^2-xeq^2) * x
onde k = 1 N/m. 
a) Faça o diagrama de energia desta energia potencial. Qual o movimento quando a energia total for menor que 1 J? """

x = np.linspace(-6,6 ,10000)
k = 1
xeq = 1.5
Epot = 0.5*k*(x**2-xeq**2)**2

plt.plot(x,Epot)
axis = plt.gca()
axis.set_ylim(0,10)
plt.grid()
plt.show()