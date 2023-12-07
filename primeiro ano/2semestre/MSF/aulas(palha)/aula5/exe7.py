import numpy as np
import matplotlib.pyplot as plt
import sympy as sy

y0 = 0
x0 = 0
t = [1,2,3,4]
colors = ["y","r","b","g"]
x=3
y=4

for tempo in t:
    plt.arrow(2*tempo,tempo**2,2,2*tempo,color =colors[tempo-1],width= 0.05) 
plt.show()