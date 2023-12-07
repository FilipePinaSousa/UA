import matplotlib.pyplot as plt
import numpy as np

#a)
t = np.linspace(0,25,100)
v_car = 70000/3600
v_limit = 40000/3600
a_pat = 2.0


plt.xlabel("Tempo (s)")
plt.ylabel("Posição (m)")
plt.plot(t,v_car*t, label=("Carro A"))
plt.plot(t,t**2, label=("Carro Patrulha"))
plt.show()

t_cruzamento = v_car
p_cruzamento = v_car*t_cruzamento
print("Instante de cruzamento: ",t_cruzamento)
print("Distãncia percorrida: ",p_cruzamento)

