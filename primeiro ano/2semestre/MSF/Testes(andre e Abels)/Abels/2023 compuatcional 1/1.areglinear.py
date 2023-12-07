import numpy as np
import matplotlib.pyplot as plt

T = np.array([0, 48, 96, 144, 192, 240, 288, 336, 384])
A = np.array([10.03, 7.06, 4.88, 3.38, 2.26, 1.66, 1.14, 0.79, 0.58])

def linreg(x, y):
    N = len(x)
    if len(x) != len(y):
        raise ValueError("Erro: x e y têm de ter o mesmo tamanho!")
    if N < 3:
        raise ValueError("Erro: O tamanho dos Arrays(N) tem de ser superior a 3!")
    
    sum_x = sum(x)
    sum_y = sum(y)
    multval = list(np.multiply(x, y))
    sum_x_times_x = sum(list(np.array(x)**2))
    sum_y_times_y = sum(list(np.array(y)**2))

    m = (N * sum(multval) - sum_x * sum_y) / (N * sum_x_times_x - (sum_x ** 2))
    b = (sum_x_times_x * sum_y - sum_x * sum(multval)) / (N * sum_x_times_x - (sum_x ** 2) )
    r_times_r = (((N * sum(multval) - sum_x * sum_y) ** 2) / ((N * sum_x_times_x - sum_x ** 2) * (N * sum_y_times_y - sum_y ** 2)))
    delta_m = abs(m) * ((((1 / r_times_r) - 1) / (N - 2))**(1/2))
    delta_b = delta_m * ((sum_x_times_x / N) ** (1/2))

    print("m = " + str(m)) #Declive
    print("b = " + str(b)) #b
    print("r\u00b2 = " + str(r_times_r)) #Coeficiente de determinação
    print("Δm = " + str(delta_m)) #Erro do declive
    print("Δb = " + str(delta_b)) #Erro do b

    return m, b


m, b = linreg(T,A) #Gráfico do logaritmo da Atividade(A) em função do Tempo(T)
line = T*m + b     #Gráfico da linha

fig, dx = plt.subplots()
dx.plot(T,A, "x") #Gráfico dos pontos
dx.plot(T, line, "b")
dx.set_xlabel("Tempo(H)")
dx.set_ylabel("Atividade(mBq)") #r² = 0.8635533523596588
dx.set_xlim(-10, 390)
dx.set_ylim(-1, 11)
dx.set_title("Atividade em função do tempo")
dx.grid()
plt.show()