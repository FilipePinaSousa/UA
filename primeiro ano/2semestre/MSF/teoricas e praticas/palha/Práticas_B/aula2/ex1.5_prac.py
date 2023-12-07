import numpy
import matplotlib.pyplot as plt

N = int(input("Nº de medições: "))
i = 0

values = []
multval = []
sum_x = 0
sum_y = 0
sum_x_times_x = 0
sum_y_times_y = 0
x_graph=[]
y_graph=[]

while i < N:
    print("Medição ",i+1)
    x = float(input("Valor de x: "))
    y = float(input("Valor de y: "))
    i += 1
    values.append((x,y))

print(values)

for value in values:
    multval.append(value[0] * value[1])
    sum_x += value[0]
    sum_y += value[1]
    x_graph.append(value[0])
    y_graph.append(value[1])
    sum_x_times_x += value[0] ** 2
    sum_y_times_y += value[1] ** 2

m = (N * sum(multval) - sum_x * sum_y) / (N * sum_x_times_x - (sum_x ** 2))

b = (sum_x_times_x * sum_y - sum_x * sum(multval)) / (N * sum_x_times_x - (sum_x ** 2) )

r_times_r = (((N * sum(multval) - sum_x * sum_y) ** 2) / ((N * sum_x_times_x - sum_x ** 2) * (N * sum_y_times_y - sum_y ** 2)))

delta_m = abs(m) * ((((1 / r_times_r) - 1) / (N - 2))**(1/2))
delta_b = delta_m * ((sum_x_times_x / N) ** (1/2))

print(m)
print(b)
print(r_times_r)
print(delta_m)
print(delta_b)
print()
plt.plot(x_graph,y_graph)
plt.xlabel("X-Label")
plt.ylabel("Y-Label")
plt.title("Graph")
plt.show()