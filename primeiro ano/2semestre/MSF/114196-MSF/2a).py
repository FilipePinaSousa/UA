from cProfile import label
import matplotlib.pyplot as plt
import numpy as np


def main() :
    x2, y2 = lançamento_res(200,15,9.8,25,0,0.001) #lançamento_res(v0,theta,g, tf,t0,dt):
    
    plt.plot(x2, y2, color='red')

    plt.ylabel("Altura (m)")
    plt.xlabel("Distância Percorrida (m)")
    plt.grid()
    plt.show()


def lançamento_res(v0,theta,g, tf,t0,dt):
    #x2, y2 = lançamento_res()
    n = int((tf - t0)/dt)
    v0 = v0/3.6
    
    
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
    y[0] = 0
    t[0] = 0
    ax[0] = 0
    ay[0] = 0
    cRes = 0.5
    dAr= 1.225 #densidade do ar
    raio= (42.7/1000)/2 #raio em m
    Area= np.pi*raio**2
    m = 45.9/1000 #massa do volante
    

    for i in range (n):
        t[1+i] = t[i] + dt
        vel = (vx[i]**2 + vy[i]**2)**(0.5)

        ax[i] = -0.5*(cRes*Area*vel*dAr*vx[i])/m
        ay[i] = -g -0.5*(cRes*Area*vel*dAr*vy[i])/m

        vx[1+i] = vx[i] + ax[i]*dt
        vy[i + 1] = vy[i] + ay[i] * dt  

        x[i + 1] = x[i] + vx[i] * dt  
        y[i + 1] = y[i] + vy[i] * dt

    # descobrir o máximo vy = 0
    maximo = 0
    tmax = 0
    for i in range(vy.size):
        if y[i-1] < y[i] and y[i+1] < y[i]:
            maximo = y[i]
            tmax = t[i]
    print("A altura máxima atingida pela bola foi {:.2f}m, no instante {:.2f}s.".format(maximo, tmax))

    # descobrir o alcance y = 0
    alcance = 0
    talc = 0
    for i in range(y.size):
        if y[i]*y[i-1] < 0:
            alcance = x[i]
            talc = t[i]
    print("O alcance da bola foi {:.2f}m e demorou {:.2f}s até o atingir.".format(alcance, talc)) 

    # print gráfico da altura em distância percorrida do tempo
    plt.plot(x, y, color='m')
    plt.ylabel("Altura (m)")
    plt.xlabel("Distância Percorrida (m)")
    plt.grid()
    plt.show()

    return x,y
  

main()
#nota a altura maxima e dada como v(x) = 0