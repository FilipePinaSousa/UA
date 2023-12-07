from cProfile import label
import numpy as np
import matplotlib.pyplot as plt

def posição(dt,tf,v0y):
    t0 = 0
    n = np.int((tf-t0) /dt + 0.1)
    #Arrays com as variáveis
    t = np.zeros(n +1)
    y = np.zeros(n+1)
    vy = np.zeros(n+1)

    g = 9.8
    t[0] = 0
    vy[0] = v0y
    y[0] = 0

    for i in range(n):
        
        t[i+1] = t[i] + dt
        vy[i+1] = vy[i] - g*dt
        y[i+1]=y[i]+vy[i]*dt
    
    thmax = v0y/g
    hmax = v0y*thmax - g*thmax/2
    print("Altura máxima {:.2f} m".format(hmax))
    print("Instante no qual a altura é máxima:  {:.2f} s".format(thmax))
    print("Instante no qual a bola volta a passar pela altura inicial:  {:.2f} s".format(2*thmax))        
    
    return t,vy,y
    
def main():
    a,b,c = posição(0.01,4,10)
    d,e,f = posição(0.1,4,10)
    # print gráfico da posição em função do tempo

    plt.plot(a, c, color='red')
    plt.plot(d, f, color='black')
    plt.ylabel("Posição (m)")
    plt.xlabel("Tempo (s)")
    plt.legend(['dt = 0.01', 'dt = 0.1'], loc=9)
    plt.show()

    
    
    

main()


