N = 10000;
Ta = 0.001;

[x,t] = GeraSinal(N,Ta);        %funçao que gera ruido aleatorio
plot(t,x)
grid on
hold on

[X,f] = Espetro(x,Ta);          %funçao que o espectro do sinal com ruido
filtro = zeros(1,length(f));    
filtro(abs(f)<2) = 1;
Y = filtro' .* X;

[X,T] = Reconstroi(Y,f);
legend("Original","Espetro","Filtrado")
xlim([0 5])
ylim([-2 2])