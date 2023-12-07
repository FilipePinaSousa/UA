# -*- coding: utf-8 -*-


import numpy as np
import matplotlib.pyplot as plt


ang = -5

res_rol = 0.04 #Coeficiente de resistencia piso
res_ar = 0.25 #Coeficiente resistencia ar 
A = 2.0 #m^2 (Area Frontal)
x0 = 0
v0 = 20.0 #m/s
m = 2000 #Massa total
P = -30 * 1000 #Potencia em Watts

ti = 0
tf = 50
dt = 0.001
n = int((tf - ti) / dt + 0.1) # +0.1 para garantir não arredondar para baixo
print('n',n)

t = np.linspace(ti,tf,n+1)

def planoInclinado_res_1D(x0,v0,n,dt,res_ar,res_piso,A,m,P,ang):
    x=np.zeros(n+1)
    vx=np.zeros(n+1)
    ax=np.zeros(n+1)
    
    p_ar=1.225 #kg por metro cubico
    g=9.8
    
    x[0]=x0
    vx[0]=v0
    ax[0]=0
    
    for i in range(n):
        vv=np.abs(vx[i])
        ax[i]=-g*np.sin(ang) - res_piso*g*np.cos(ang) -(0.5*res_ar*A*p_ar*vx[i]*vv)/m + P/(m*vx[i])
        vx[i+1]=vx[i]+ax[i]*dt
        x[i+1]=x[i]+vx[i]*dt
        
        if x[i] > -2000 and x[i + 1] <= -2000:
            t_2km = t[i + 1]
            Wf = 0.5 * m * vv
            
    return x,vx, t_2km, Wf

values = planoInclinado_res_1D(x0,v0,n,dt,res_ar,res_rol,A,m,P,ang)
print("O carro eleétrico demorou ", values[2], " segundos a percorrer 2 km") #Aprox: 23.61 segundos
print("O trabalho feito pelo motor após a viagem de 2km foi ", values[3], "J") 
# Wtotal = Wf - Wi. Wi = 0, logo Wtotal = Wf


v = values[0]

plt.xlabel("t (s)")
plt.ylabel("m (m)")
plt.plot(t,v)
plt.grid()
plt.show()