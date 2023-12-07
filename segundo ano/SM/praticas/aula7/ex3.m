clear
close all
clc

load("Guitar03.mat")

R=0.9; 
teta=2*pi*(5000/fa);
num=[1 -2*cos(teta) 1];
den=[1 -2*R*cos(teta) R^2];

[H,f]=respfreq(num,den,fa);

teta=2*pi*(5000/fa);
xr=x+ 0.6*cos(teta*(0:length(x)-1)'+0.1*pi);
t = ((0:length(xr)-1) * fa); 

y = filter(num, den, xr);

figure;

subplot(3,1,1);
plot(t, xr);
title('Sinal de Entrada (xr)');
xlabel('Tempo (s)');
ylabel('Amplitude');

subplot(3,1,2);
plot(f, abs(H));
title('Módulo da Resposta em Frequência (|H(f)|)');
xlabel('Frequência (Hz)');
ylabel('|H(f)|');

subplot(3,1,3);
ty = 0:1/fa:length(y)/fa-1/fa;
plot(ty, y);
title('Sinal Filtrado (y)');
xlabel('Tempo (s)');
ylabel('Amplitude');

% sound(y, fa);

figure;
Espetro(xr, 1/fa);
title('Espetro do sinal (xr)');

figure;
Espetro(y, 1/fa);
title('Espetro do sinal (y)');

