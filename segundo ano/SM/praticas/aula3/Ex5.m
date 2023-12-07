Ta = 0.001;
f0 = 1;
Np = 6;
k = 10;

ak = zeros(1, k);
bk = zeros(1, k - 1);

impares = 1:2:k-1;
pares = 2:2:k-2;

ak(impares) = 4 ./ (impares * pi);
ak(pares) = 0;

[x, t] = fourierfunc(Ta, f0, Np, ak, bk);



% Plote o sinal x(t) e o sinal original (no seu caso, uma onda quadrada)
y = square(2 * pi * f0 * t);

figure(1);
hold on
plot(t, x);
plot(t, y);
xlabel('t');
ylabel('x(t)');
title('Gráfico da Onda Quadrada vs. Série Exponencial de Fourier');
grid on;
legend('Série Exponencial de Fourier', 'Onda Quadrada Original');
