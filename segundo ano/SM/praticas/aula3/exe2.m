%Ex2.

Ta = 0.001;
f0 = 1;
Np = 6;
k = 10;


ak = zeros(1,k);
bk = zeros(1,k-1);

impares = 1:2:k-1;
bk(impares) = 4./(impares*pi);
bk = [0,bk];

[x,t] = fourierfunc(Ta,f0,Np,ak,bk);

y = square(2*pi*1*t);

figure(1);

hold on
plot(t,x);
plot(t,y);
xlabel('t');
ylabel('x(t)');
title("Grafico Onda Sinusoidal");
grid on;


