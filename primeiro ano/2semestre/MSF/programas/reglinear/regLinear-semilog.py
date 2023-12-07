
import matplotlib.pyplot as plt
import numpy as np


def main():
    # Dados para a regressão
    x = np.array([0,5,10,15,20,25,30,35,40,45])# TEMPO EM SEMANAS
    y = np.array([10.07,6.293,3.831,2.500,1.409,0.8775,0.5369,0.3522,0.2173,0.1357])#ATIVIDADE
    # x = np.log(x)
    y = np.log(y)
        # calcular a regressão linear ()
    data = regression(x, y) # [m, b, r^2, deltam, deltab]

    # print m, b, r^2, deltam, deltab
    print("m={}, b={}, r^2={}, deltam={}, deltab={}".format(data[0], data[1], data[2], data[3], data[4]))


    # mostrar o gráfico log(x), log(y) e os pontos
    plt.plot(x, data[0]*x+data[1]) # reta
    plt.scatter(x, y, marker='o', color='m') # pontos
    plt.xlabel("")
    plt.ylabel("")
    plt.show()
    



def regression(x, y):
    n = len(x) # número de medições

    # obter os somatórios necessários
    sum_x = np.sum(x)
    sum_y = np.sum(y)
    sum_xx = np.sum(x**2)
    sum_yy = np.sum(y**2)
    sum_xy = np.sum(np.multiply(x, y))

    # calcular m, b, r^2, deltam, deltab

    m = (n*sum_xy - sum_x*sum_y)/(n*sum_xx - sum_x**2)
    b = (sum_xx*sum_y - sum_x*sum_xy)/(n*sum_xx - sum_x**2)
    rr = (n*sum_xy - sum_x*sum_y)**2/((n*sum_xx - sum_x**2)*(n*sum_yy - sum_y**2))
    deltam = np.abs(m)*np.sqrt(((1/rr)-1)/(n-2))
    deltab = deltam*np.sqrt(sum_xx/n)

    return m, b, rr, deltam, deltab

main()