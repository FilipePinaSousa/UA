cres = 0.9
g = 9.8
m = 75
u = 0.004
pAr = 1.225
area = 0.30
v = 30/3.6


pot = (cres/2 * area* pAr * v**2 + u*m*g)*v
print(pot)