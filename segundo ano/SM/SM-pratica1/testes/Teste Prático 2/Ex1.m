load('Guitar01.mat')
sound(x, fa)

Ta = 1/fa;
t=0:Ta:length(x)/fa-Ta;
figure(1)
plot(t,x)
xlabel("Tempo (s)")
ylabel("Sinal")