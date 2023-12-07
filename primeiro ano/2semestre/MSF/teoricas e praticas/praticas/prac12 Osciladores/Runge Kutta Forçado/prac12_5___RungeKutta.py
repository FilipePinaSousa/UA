import numpy as np
import matplotlib.pyplot as plt

def acel(t, x, v, g, vt):                                               #aceleração
    return g - g / (vt ** 2) * np.abs(v) * v    

def rk4_1D(t, x0, v0, dt, n, g, vt):                                        #Runge-Kutta 4ª ordem
    x = np.empty(n + 1)
    x[0] = x0
    v = np.empty(n + 1)
    v[0] = v0
    for i in range(n):
        ax1 = acel(t[i], x[i], v[i], g, vt)
        c1v = ax1 * dt
        c1x = v[i] * dt
        
        ax2 = acel(t[i] + dt / 2, x[i] + c1x / 2, v[i] + c1v / 2, g, vt)
        c2v = ax2 * dt
        c2x = (v[i] + c1v / 2) * dt
        
        ax3 = acel(t[i] + dt / 2, x[i] + c2x / 2, v[i] + c2v / 2, g, vt)
        c3v = ax3 * dt
        c3x = (v[i] + c2v / 2) * dt
        
        ax4 = acel(t[i] + dt, x[i] + c3x, v[i] + c3v, g, vt)
        c4v = ax4 * dt
        c4x = (v[i] + c3v) * dt
        
        x[i + 1] = x[i] + (c1x + 2 * c2x + 2 * c3x + c4x) / 6
        v[i + 1] = v[i] + (c1v + 2 * c2v + 2 * c3v + c4v) / 6
    
    return x, v

def euler(t, x0, v0, dt, n, g, vt):                                        #Euler                           
    x = np.empty(n + 1)
    x[0] = x0
    v = np.empty(n + 1)
    v[0] = v0
    for i in range(n):
        a = acel(t[i], x[i], v[i], g, vt)
        v[i + 1] = v[i] + a * dt
        x[i + 1] = x[i] + v[i] * dt
    
    return x, v

g = 9.8                                 #aceleração da gravidade
tf = 4                                #tempo final                      
dt = 0.5                        #passo de tempo                     
n = int(tf / dt)            #número de pontos           
t = np.linspace(0, tf, n + 1)   #vetor tempo            
vt = 6.8                    #velocidade terminal        
v0 = 0                    #velocidade inicial                   
x0 = 0                  #posição inicial            

v_rk = rk4_1D(t, x0, v0, dt, n, g, vt)[1]                      #vetor velocidade obtido pelo método de Runge-Kutta                       
v_eu = euler(t, x0, v0, dt, n, g, vt)[1]                        #vetor velocidade obtido pelo método de Euler
v_ex = vt * np.tanh(g * t / vt)                                 #vetor velocidade exata

ind = np.where(t >= 2)[0][0]                                    #índice do vetor tempo onde t = 2s

print("tf=2s:\nVelocidade obtida pelo método de Runge-Kutta: {:.6f} m/s".format(v_rk[ind]))
print("Velocidade obtida pelo método de Euler: {:.6f} m/s".format(v_eu[ind]))
print("Velocidade exata: {:.6f} m/s".format(v_ex[ind]))

plt.plot(t, v_rk, label="Runge-Kutta")
plt.plot(t, v_ex, label="Valor exato")
plt.plot(t, v_eu, label="Euler")
plt.axhline(vt, label="velocidade terminal")
plt.legend()
plt.grid()
plt.xlabel("Tempo (s)")
plt.ylabel("Velocidade (m/s)")
plt.show()
