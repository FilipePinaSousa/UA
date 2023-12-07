import math as math
import matplotlib.pyplot as plt

opt = int(input("1 - Angulo em radianos         2- Angulos em graus         "))
ang = int(input("Ângulo: "))
mod_F = 5

if opt==1:
    Fx = mod_F*math.cos(ang)
    Fy = mod_F*math.sin(ang)
    F= [Fx,Fy]
    print(F)


if opt==2:
    Fx = mod_F*math.cos(math.radians(ang))
    Fy = mod_F*math.sin(math.radians(ang))
    F= [Fx,Fy]
    print(F)

plt.arrow(0,0,F[0],F[1],color='r',width=0.1)
plt.show()