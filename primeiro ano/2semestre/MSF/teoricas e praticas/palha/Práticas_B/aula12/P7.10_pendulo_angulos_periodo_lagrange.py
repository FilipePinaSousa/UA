import matplotlib.pyplot as plt
import numpy as np
'''
ang = deslocamento angular
w = velocidade angular
alfa = aceleração angular
'''
def maxminv(xm1,xm2,xm3,ym1,ym2,ym3):
# Máximo ou mínimo usando o polinómio de Lagrange
# Dados (input): (x0,y0), (x1,y1) e (x2,y2)
# Resultados (output): xm, ymax
    xab=xm1-xm2
    xac=xm1-xm3
    xbc=xm2-xm3
    a=ym1/(xab*xac)
    b=-ym2/(xab*xbc)
    c=ym3/(xac*xbc)
    xmla=(b+c)*xm1+(a+c)*xm2+(a+b)*xm3
    xm=0.5*xmla/(a+b+c)
    xta=xm-xm1
    xtb=xm-xm2
    xtc=xm-xm3
    ymax=a*xtb*xtc+b*xta*xtc+c*xta*xtb
    return xm, ymax


t0 = 0.0
tf = 20
dt = 0.001
n = int((tf-t0)/dt)
l = 1
g = 9.8
w0 = 0
ang0 = 30*np.pi/180  # mudar o ângulo em graus aqui

t = np.zeros(n+1)
ang = np.zeros(n+1)
w = np.zeros(n+1)

ang[0] = ang0
w[0] = w0

for i in range(n):
    t[i+1] = t[i] + dt
    alfa = -g*np.sin(ang[i])/l
    w[i+1] = w[i] + alfa * dt
    ang[i+1] = ang[i] + w[i+1] * dt

peaks = []
for i in range(n):
    if(ang[i-1]<ang[i] and ang[i]>ang[i+1] and t[i]>0):
        peaks.append(i)


tmax = np.zeros(len(peaks))
angmax = np.zeros(len(peaks))
c=0
for i in peaks:
    tmax[c], angmax[c] = maxminv(t[i-1], t[i], t[i+1], ang[i-1], ang[i], ang[i+1])
    c+=1

amplitude = np.mean(angmax)*180/np.pi
print("Amplitude", amplitude)  # deve resultar no valor em graus do ângulo inicial
periodo = tmax[1]-tmax[0]
print("Período", periodo)

plt.title("Posição x tempo")
plt.plot(t,ang)
plt.show()
