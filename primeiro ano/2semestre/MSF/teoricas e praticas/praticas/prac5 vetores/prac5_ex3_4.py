import matplotlib.pyplot as plt
import math as math

v = [3,4]
u = [4,-3]

x=v[0]
y=v[1]

Fx = 2
o = 60
F=Fx/math.cos(math.pi/3) 
F=Fx/math.cos(math.radians(60))       # graus para radianos

print("F = ",F," N")
plt.arrow(0,0,x,y,color='b',width=0.2)
plt.arrow(0,0,u[0],u[1],color='r',width=0.2)
plt.show()