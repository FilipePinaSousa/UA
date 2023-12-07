import matplotlib.pyplot as plt
import numpy as np

def alinec():
    m=1000 
    k=2
    xeq=1 #!ponto de equilibrio 
    tf=20
    ti=0

    dt= 0.01
    n=int((tf-ti)/dt)
    t=np.linspace(ti,n*dt,n)

    x0=1.3
    vx0=0
    ax0=-1.3

    x_=np.empty(n)
    vx_=np.empty(n)
    ax_=np.empty(n)
    em=np.zeros(n)

    x_[0]=x0
    vx_[0]=vx0
    em[0]= 0.5*(np.abs(x_[0])-xeq)**2*m + 0.5* vx_[0]**2*m

    maxxtotal=0
    countmax=0
    maxtempos=[]
    tempototal=0

    ind = np.transpose([0 for i in range(1000)])

    #15 é um numero arbitario e calculo as 5 primeiras frequencias
    afo=np.zeros(15)
    bfo=np.zeros(15)

    for i in range(n-1):

        vx_[i+1]=vx_[i]+ax_[i]*dt
        x_[i+1] =x_[i]+vx_[i+1]*dt

        if x_[0]<0:
            ax_[i+1]= -x_[i+1] - xeq
        else:
            ax_[i+1]= -x_[i+1] + xeq

        fx=ax_[i]/m
        em[i]=  0.5*(np.abs(x_[i])- xeq)**2*m + 0.5*vx_[i]**2*m


    t0=ind[countmax-1]
    t1=ind[countmax]

  

    li=np.linspace(0,14,15)

    for i in range(countmax-1):
        tempototal+=maxtempos[i+1]-maxtempos[i]

    print("-----------------Alinea (c)-------------------")
    