import math
import matplotlib.pyplot as plt 
import numpy as np
from scipy import stats

def calcReg(x1,y1):
# b) ------------------------------
  assert len(x1) == len(y1)
  n = len(x1)
  x = sum(x1)
  y = sum(y1)
  xy = sum(x1[i] * y1[i] for i in range (n))
  xx = sum(x1[i]**2 for i in range(n))
  yy = sum(y1[i]**2 for i in range(n))

# c) ------------------------------
  m = (n * xy - x * y)/(n * xx - x**2)
  b = (xx * y - x * xy)/(n * xx - x**2)
  r2 = (((n*xy)-(x*y))**2)/(((n*xx)-(x**2))*((n*yy)-(y**2)))
  deltaM = abs(m) * math.sqrt( ((1/r2)-1)/(n-2) )
  deltaB = deltaM * math.sqrt(xx/n)

  print("x = ", x)
  print("y = ", y)
  print("xy = ", xy)
  print("yy = ", yy)
  print("m = ", m)
  print("b = ", b)
  print("r2 = ", r2)
  print("deltaM = ", deltaM)
  print("deltaB = ", deltaB)
  return m, b

def graph(x1,y1,m,b):

# a) --------------------------
  plt.plot(x1,y1,"o") # pontos exp
  plt.title("Representação dos pontos experimentais")
  plt.xlabel('L(cm)') 
  plt.ylabel('X(cm)') 
  plt.show()

# d) --------------------------
  x = np.linspace(np.min(x1)*0.9, np.max(x1)*1.1, 10000) # determina eixo das abcissas (separado em 1000 espaços iguais)
  plt.plot(x, x * m + b) # f, f(x) --> reta de regressão linear
  plt.plot(x1,y1,"ro") # pontos exp
  plt.title("Representação da reta de regressão linear")
  plt.xlabel('L(cm)') 
  plt.ylabel('X(cm)') 
  plt.show()

# e) --------------------------
  X = 165 * m + b

# refaz o gráfico da alínea d
  x = np.linspace(np.min(x1)*0.9, np.max(x1)*1.1, 10000)
  plt.plot(x, x * m + b)
  plt.plot(x1,y1,"ro")
  plt.title("Representação da reta de regressão linear")
  plt.xlabel('L(cm)') 
  plt.ylabel('X(cm)') 

# representa o ponto L = 165.0 
  plt.plot(165.0 ,X,"go")
  plt.show()



  
def main():
  L = [222,207.5,194,171.5,153,133,113,92]
  x = [2.3,2.2,2,1.8,1.6,1.4,1.2,1]
  m, b = calcReg(L,x)
  graph(L,x,m,b)
# f) --------------------------
  print("\nNovos pontos:\n")
  L2 = [222.0,207.5,194.0,171.5,153.0,133.0,113.0,92.0] 
  X2 = [2.3,2.2,2.0,2.1,1.6,1.4,1.2,1.0]
  m2, b2 = calcReg(L2,X2)
  graph(L2,X2,m2,b2)
  # O novo coeficiente de determinação é pior que o primeiro r'= 0951 < r= 0.998

main()