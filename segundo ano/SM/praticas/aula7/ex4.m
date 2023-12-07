clear
close all
clc

[x, fa] = audioread("vozportugues.wav");

Ta = 1/fa;
a = 0.9;

dist = 17;

t_total = 2*17/340;
D = t_total/Ta;

num=[1 zeros(1,D-1) a];
den = 1;

[H,f]=respfreq(num,den,fa);

t = ((0:length(x)-1) * fa); 

y = filter(num, den, x);

figure;

subplot(3,1,1);
plot(t, x);
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
Espetro(x, 1/fa);
title('Espetro do sinal (x)');

figure;
Espetro(y, 1/fa);
title('Espetro do sinal (y)');

%% d)

D = 10;
a = 0.9;

num=[1 zeros(1,D-1) a];
den = 1;

[H,f]=respfreq(num,den,fa);

t = ((0:length(x)-1) * fa); 

y = filter(num, den, x);

figure;

subplot(3,1,1);
plot(t, x);
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
Espetro(x, 1/fa);
title('Espetro do sinal (x)');

figure;
Espetro(y, 1/fa);
title('Espetro do sinal (y)');

