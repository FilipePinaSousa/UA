import numpy as np
from matplotlib import pyplot as plt

def oscQuartFA_1D(x0,v0,k,m,t,b,F0,w_f,alpha,n,dt):                                 
    #oscilador Quártico sujeito forçado e amortecido
    x=np.empty(n+1)
    v=np.empty(n+1)
    a=np.empty(n+1)
    x[0]=x0
    v[0]=v0
    for i in range(n):                                                                  #loop para calcular a posição, velocidade e aceleração    
        a[i]=-k/m*x[i]*(1+2*alpha*x[i]**2)+(-b*v[i]+F0*np.cos(w_f*t[i]))/m          
        v[i+1]=v[i]+a[i]*dt
        x[i+1]=x[i]+v[i+1]*dt
    return x,v,a

m=1                     #massa         
x_eq=0                  #posição de equilíbrio
k=1                    #constante da mola                                                    
b=0.05                #coeficiente de amortecimento                     
alpha=0.002            #coeficiente do termo quártico
F0=7.5              #amplitude da força externa             
w_f=1.0             #frequência angular da força externa
v0=0                #velocidade inicial         
x0=4            #posição inicial        

tf=200            #tempo final  
dt=0.01                 #passo de tempo
n=int(tf/dt)        #número de pontos
t=np.linspace(0,tf,n+1)    #vetor tempo

results=oscQuartFA_1D(x0,v0,k,m,t,b,F0,w_f,alpha,n,dt)          
x=results[0]    

plt.plot(t,x,label="x(t)")
plt.xlabel("t (s)")
plt.ylabel("x (m)")
plt.grid()
plt.legend()
plt.show()