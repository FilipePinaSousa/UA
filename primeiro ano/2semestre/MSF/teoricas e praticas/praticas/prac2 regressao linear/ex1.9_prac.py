import numpy
import matplotlib.pyplot as plt

R=[9.676,6.355,4.261,2.729,1.862,1.184,0.7680,0.4883,0.3461,0.2119]
D=[5,10,15,20,25,30,35,40,45,50]

plt.semilogy(D,R)
plt.title("Variação Atividade Radioativa Isótopo Radiativo 131I")
plt.xlabel("Dias")
plt.ylabel("Atividade Radioativa (mCi)")
plt.show()