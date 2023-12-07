import numpy
import matplotlib.pyplot as plt

T=[200,300,400,500,600,700,800,900,1000,1100]
E=[0.6950,4.363,15.53,38.74,75.08,125.2,257.9,344.1,557.4,690.7]

plt.plot(T,E, "o")
plt.xlabel("T")
plt.ylabel("E")
plt.title("Graph")
plt.show()