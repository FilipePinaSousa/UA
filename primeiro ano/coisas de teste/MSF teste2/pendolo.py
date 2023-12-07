# Dados do problema
m_bloco = 1 # kg
m_bala = 28/1000 # kg
v_bala = 1000/3.6 # m/s
L = 1 # m

# Conservação de momento linear
pala = m_bala * v_bala
p_bloco = 0
p_total = p_bala + p_bloco
v_total = p_total / (m_bloco + m_bala)

print(f"Velocidade do conjunto bloco-bala após a colisão: {v_total:.2f} m/s")
# Conservação de energia
Ec_bala = (1/2) * m_bala * v_bala**2
Ec_bloco = 0
Ec_total = Ec_bala + Ec_bloco

print(f"Energia cinética do conjunto bloco-bala após o impacto: {Ec_total:.2f} J")
# Energia mecânica antes da colisão
Em_inicial = (1/2) * (m_bloco + m_bala) * v_bala**2

# Energia mecânica depois da colisão
Em_final = Ec_total

print(f"Energia mecânica antes da colisão: {Em_inicial:.2f} J")
print(f"Energia mecânica depois da colisão: {Em_final:.2f} J")