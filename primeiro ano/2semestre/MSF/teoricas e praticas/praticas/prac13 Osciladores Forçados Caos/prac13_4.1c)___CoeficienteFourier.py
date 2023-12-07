import numpy as np
from matplotlib import pyplot as plt

def oscQuartFA_1D(x0,v0,k,m,t,b,F0,w_f,alpha,n,dt):
    #oscilador Quártico sujeito forçado e amortecido
    x=np.empty(n+1)
    v=np.empty(n+1)
    a=np.empty(n+1)
    x[0]=x0
    v[0]=v0
    for i in range(n):
        a[i]=-k/m*x[i]*(1+2*alpha*x[i]**2)+(-b*v[i]+F0*np.cos(w_f*t[i]))/m          #equação da aceleração
        v[i+1]=v[i]+a[i]*dt                                                         #calculo da velocidade                                                 
        x[i+1]=x[i]+v[i+1]*dt                                                    #calculo da posição                    
    return x,v,a

def fourier(x0,v0,m,k,b,F0,w_f,A,t,n,t_estac,alpha): 
    #faz a preparação necessária ao cálculo dos coeficientes de Fourier e apresenta-os num gŕafico de barras
    #atençáo: alterar a equaçáo da aceleração se necessário
    x=np.empty(n+1)
    v=np.empty(n+1)
    a=np.empty(n+1)
    
    v[0]=v0
    x[0]=x0
    cntMax=0
    ind=np.transpose([0 for i in range(1000)])              #vetor que guarda os índices dos máximos
    afo=np.zeros(15)                                    #vetor que guarda os coeficientes de Fourier                    
    bfo=np.zeros(15)                                #vetor que guarda os coeficientes de Fourier            

    
    for i in range(n):
        a[i]=-(k/m)*x[i]*(1+2*alpha*x[i]**2)-(b/m)*v[i]+(F0/m)*np.cos(w_f*t[i])             #equação da aceleração
        v[i+1]=v[i]+a[i]*dt                                                                 #calculo da velocidade
        x[i+1]=x[i]+v[i+1]*dt                                                            #calculo da posição                            
        if t[i]>t_estac and x[i-1] < x[i] and  x[i+1] < x[i]  :
    		# maxx, maxy=maximo(t[i-1], t[i], t[i+1], x[i-1], x[i], x[i+1])
    		# ampl=ampl+maxy
            cntMax=cntMax+1
            ind[cntMax]=int(i) #NOTA TEM DE SER UM INT
    		
    t0=ind[cntMax-1]            
    t1=ind[cntMax]        
    for i in range(15):                         #cálculo dos coeficientes de Fourier
        af, bf=fourier_calc(t,x,t0,t1,i)
        afo[i]=af
        bfo[i]=bf

    ii=np.linspace(0,14,15)                     #apresentação dos coeficientes de Fourier
    plt.figure()
    plt.ylabel('| a_n |')
    plt.xlabel('n')
    plt.bar(ii,np.abs(afo))
    plt.grid()
    plt.show()



    ii=np.linspace(0,14,15)                 #apresentação dos coeficientes de Fourier
    plt.figure()
    plt.ylabel('| b_n |')
    plt.xlabel('n')
    plt.bar(ii,np.abs(bfo))
    plt.grid()
    plt.show()
    

def fourier_calc(tp,xp,it0,it1,nf):                 #cálculo dos coeficientes de Fourier
    dt=tp[1]-tp[0]                                  #intervalo de tempo
    per=tp[it1]-tp[it0]                            #período             
    ome=2*np.pi/per                             #frequência angular

    s1=xp[it0]*np.cos(nf*ome*tp[it0])           #primeiro termo da série de Fourier                 
    s2=xp[it1]*np.cos(nf*ome*tp[it1])        #último termo da série de Fourier  
    st=xp[it0+1:it1]*np.cos(nf*ome*tp[it0+1:it1])       #termos intermédios da série de Fourier
    soma=np.sum(st)                         #soma dos termos intermédios da série de Fourier
    
    q1=xp[it0]*np.sin(nf*ome*tp[it0])        #primeiro termo da série de Fourier
    q2=xp[it1]*np.sin(nf*ome*tp[it1])           #último termo da série de Fourier   
    qt=xp[it0+1:it1]*np.sin(nf*ome*tp[it0+1:it1])    #termos intermédios da série de Fourier
    somq=np.sum(qt)                             #soma dos termos intermédios da série de Fourier
    
    intega=((s1+s2)/2+soma)*dt              #integral da série de Fourier
    af=2/per*intega                         #coeficiente de Fourier a_n
    integq=((q1+q2)/2+somq)*dt              #integral da série de Fourier
    bf=2/per*integq                         #coeficiente de Fourier b_n
    return af,bf                            #coeficiente de Fourier b_n

m=1             #massa
x_eq=0          #posição de equilíbrio
k=1             #constante elástica
b=0.05          #coeficiente de amortecimento
alpha=0.002     #coeficiente de não linearidade
F0=7.5          #amplitude da força externa
w_f=1.0         #frequência da força externa
v0=0            #velocidade inicial
x0=3            #posição inicial

tf=200          #tempo final
dt=0.0001       #intervalo de tempo
n=int(tf/dt)    #número de iterações
t=np.linspace(0,tf,n+1)     #vetor tempo

results=oscQuartFA_1D(x0,v0,k,m,t,b,F0,w_f,alpha,n,dt)          #chamada da função oscQuartFA_1D
x=results[0]

t_estac=150 #estimado
ind_estac=[i for i in range(n) if t[i]>=t_estac][0] #índice a partir do qual estima-se que estamos em regime estacionário

ind_max=[i for i in range(ind_estac,n-1) if x[i-1]<=x[i]>=x[i+1]] #lista de índices onde x é máximo, em regime estacionário
t_max=[t[i] for i in ind_max] #t quando x é máximo
x_max=[x[i] for i in ind_max] #x máximos
A=np.average(x_max)
T=np.average([t_max[i+1]-t_max[i] for i in range(len(t_max)-1)])

print("Amplitude: {:f}m".format(A))
print("Período: {:f}s".format(T))

fourier(x0,v0,m,k,b,F0,w_f,A,t,n,t_estac,alpha)