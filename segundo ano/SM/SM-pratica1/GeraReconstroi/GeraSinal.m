function [x,t] = GeraSinal(N,Ta)
t = (0: (N-1))'*Ta;

phi = randn(N,1)*pi;                                    %media nula desvio padrao pi; randn(N,1) * pi + 0
phi_i1 = zeros(N,1);
for n=2:N
    phi_i1(n) = phi_i1(n-1) + (phi(n)+phi(n-1))*Ta/2;   %resultado da integração (ao longo do tempo) de uma variável aleatória de distribuição normal   
end

phi = randn(N,1)*pi;
phi_i2=zeros(N,1);
for n=2:N
    phi_i2(n) = phi_i2(n-1) + (phi(n)+phi(n-1))*Ta/2;   %resultado da integração (ao longo do tempo) de uma variável aleatória de distribuição normal  
end

x=sin(2*pi*t)+0.5*sin(2*pi*10*t + 10*phi_i1) + 0.5*sin(2*pi*12*t + 10*phi_i2);  %sinal dado com ruido 
end