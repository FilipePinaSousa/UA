from cProfile import label
import matplotlib.pyplot as plt
import numpy as np


def main() :
    #COM o paraquedas fechado
    x2, y2 = lançamento_res(0,60,90,9.8,120,0,0.001) #(v0,vterminal,theta,g, tf,t0,dt): 
    plt.plot(x2, y2, color='red')

    plt.ylabel("Altura (m)")
    plt.xlabel("Distância Percorrida (m)")
    plt.grid()
    plt.show()




    # Levando em consideração a resistência do ar

def lançamento_res(v0,vterminal,theta,g, tf,t0,dt):
    n = int((tf - t0)/dt)
    
    ax = np.zeros(n+1)
    ay = np.zeros(n+1)

    vx = np.zeros(n+1)
    vy = np.zeros(n+1)
    x = np.zeros(n+1)
    y = np.zeros(n+1)
    t = np.zeros(n+1)

    theta = np.deg2rad(theta)

    vx[0] = v0*np.cos(theta)
    vy[0] = v0*np.sin(theta)
    x[0] = 0
    y[0] = 800 #Altura inicial
    t[0] = 0
    ax[0] = 0
    ay[0] = g
    dres = g/vterminal**2

    for i in range (n):
        
            
        t[1+i] = t[i] + dt
        vel = (vx[i]**2 + vy[i]**2)**(0.5)
        if t[i] > 10 :#Alínea B
            dres = g/5**2
        

        ax[i] = -dres*vel*vx[i]
        ay[i] = g - dres*vel*vy[i]

        vx[1+i] = vx[i] + ax[i]*dt
        vy[i + 1] = vy[i] + ay[i] * dt  

        x[i + 1] = x[i] + vx[i] * dt  
        y[i + 1] = y[i] - vy[i] * dt

    

    # descobrir o alcance y = 0
    velocidade = 0
    talc = 0
    for i in range(n):
        if y[i]*y[i-1] < 0:
            velocidade = vy[i]
            talc = t[i]
            print("vy: " , vy[i])
            print("t: " ,  t[i])
    print("A velocidade máxima foi {:.2f}m/s e demorou {:.2f}s até o atingir.".format(velocidade, talc)) 

    # print gráfico da altura em distância percorrida do tempo
    plt.plot(x, y, color='m')
    plt.ylabel("Altura (m)")
    plt.xlabel("Distância Percorrida (m)")
    plt.grid()
    plt.show()

    return x,y
  




main()
