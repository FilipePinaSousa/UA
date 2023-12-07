load("Guitar01.mat");
fa_new = 2*fa;
sound(x, fa);
Ta = 1/fa_new;

figure(1)
Espetro(x,Ta);
title("Espetro das notas musicais")
axis([-5e3 5e3 0 4e-3])

t=0:Ta:length(x)/fa_new-Ta;
figure(2)
plot(t,x)
xlabel("Tempo (s)")
ylabel("Sinal")
