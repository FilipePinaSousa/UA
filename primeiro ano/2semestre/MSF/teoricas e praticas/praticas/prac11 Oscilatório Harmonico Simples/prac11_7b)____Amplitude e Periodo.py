import numpy as np
import matplotlib.pyplot as plt

dt = 0.01       #passo de tempo
m = 1           #massa
k = 1           #constante da mola
t0 = 0          #tempo inicial
tf = 500            #tempo final
n = int((tf-t0)/dt)     #número de pontos
w = np.sqrt(k/m)        #frequência angular
t = np.linspace(t0, tf, n)          #vetor tempo
psi = 0         #fase
A = 4           #amplitude

x = A*np.cos(w*t+psi)       #posição

x2 = np.empty(n)            #posição
x2[0] = 4                   #posição inicial

v = np.empty(n)             #velocidade
v[0] = 0                    #velocidade inicial

a = np.empty(n)             #aceleração
a[0] = 0                    #aceleração inicial

arrayx = []                 #array para guardar os valores de x           
periodos = []                   #array para guardar os valores de tempo 
tempos = []                 #array para guardar os valores de tempo
for i in range(n-1):        #loop para calcular a posição, velocidade e aceleração
    a[i] = -k*x2[i]/m
    v[i+1] = v[i] + a[i]*dt
    x2[i+1] = x2[i]+v[i+1]*dt

    if x[i-1] < x[i] > x[i+1]:      #condição para achar os máximos
        arrayx.append(x[i])         
        tempos.append(t[i])

amplitude = sum(arrayx)/len(arrayx)         #média dos máximos


print("Amplitude: ", amplitude)


for i in range(len(tempos)-1):                  #loop para calcular os períodos
    periodos.append(tempos[i+1]-tempos[i])          

periodo = sum(periodos)/len(periodos)           #média dos períodos
print("Período: ", periodo)
