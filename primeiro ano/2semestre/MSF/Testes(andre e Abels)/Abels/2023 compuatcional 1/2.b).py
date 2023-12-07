import numpy as np
import matplotlib.pyplot as plt

def euler_integration(dt, t0, tf, x0, y0, vx0, vy0, g, vt):
    n=np.int32((tf-t0)/dt+0.1)
    t=np.zeros(n+1)

    x=np.zeros(n+1)
    y=np.zeros(n+1)
    vx = np.zeros(n+1)
    vy=np.zeros(n+1)
    ax=np.zeros(n+1)
    ay=np.zeros(n+1)

    x[0]=x0
    y[0]=y0
    vx[0]=vx0
    vy[0]=vy0
    t[0]=t0

    for i in range(n):
        if vt == 0:
            ax[i] = 0
            ay[i] = g
        else:
            ax[i] = g/vt**2 * vx[i] * np.sqrt(vx[i]**2 + vy[i]**2)
            ay[i] = g + g/vt**2 * vy[i] * np.sqrt(vx[i]**2 + vy[i]**2)

        x[i+1]=x[i]+vx[i]*dt
        y[i+1]=y[i]+vy[i]*dt
        vx[i+1]=vx[i] + ax[i]*dt
        vy[i+1]=vy[i] + ay[i]*dt
        t[i+1]=t[i]+dt

    return t, x, y, vx, vy, ax, ay

VI = 15
VT = 20

(t, x, y, *_) = euler_integration(0.001, 0, 2, 0, 2, VI*np.cos(np.deg2rad(30)), VI*np.sin(np.deg2rad(30)), -9.8, VT)


print(f'Altura máxima: {max(y)}')

plt.xlabel('x (m)')
plt.ylabel('y (m)')
plt.title("Gráfico da trajetória da bola")
plt.plot(x, y, 'r')
plt.show()

for i in range(len(y)):
    if i > 3 and y[i-1] * y[i] < 3:
        print(f'Instante: {t[i]:.2f} Ponto: ({x[i]:.2f}, {y[i]:.2f})')
        break

