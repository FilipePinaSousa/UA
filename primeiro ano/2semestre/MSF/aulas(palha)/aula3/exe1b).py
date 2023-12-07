import numpy as np

x = np.array(tempo)
y = np.array(distancia)

# Encontrar a linha de regressão
m, b = np.polyfit(x, y, 1)
regressao = m*x + b

# Calcular o erro padrão da estimativa
erro = np.sqrt(np.sum((y - regressao)**2) / (len(x) - 2))

# Calcular o coeficiente de determinação
r2 = np.corrcoef(x, y)[0, 1]**2

# Imprimir os resultados
print(f"Declive: {m:.4f}")
print(f"Ordenada na origem: {b:.4f}")
print(f"Erro padrão da estimativa: {erro:.4f}")
print(f"Coeficiente de determinação: {r2:.4f}")

# Plotar a linha de regressão
plt.plot(x, regressao, color='red')

plt.show()
