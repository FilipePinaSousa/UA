import matplotlib.pyplot as plt
import numpy as np

R = [9.676 , 6.355, 4.261, 2.729, 1.862, 1.184, 0.7680, 0.4883, 0.3461, 0.2119]
t = [0,5,10,15,20,25,30,35,40,45]

# a) ----------------------------------
plt.plot(t,R,"o")
plt.xlabel("Tempo (dias)")
plt.ylabel("Radioatividade (mCi)")
plt.show()
# Não, a relação entre os dados não é linear.

# b) ----------------------------------
logR = np.log(R)
plt.plot(t,logR,"o")
m = np.polyfit(t,logR,1)[0]
b = np.polyfit(t,logR,1)[1]
x = np.linspace(0, 50 * 1.1, 10000)
plt.plot(x, m*x+b)
plt.xlabel("Tempo (dias)")
plt.ylabel("log da Radioatividade (mCi)")
plt.show()
# A relação é linear

print(np.log(2))