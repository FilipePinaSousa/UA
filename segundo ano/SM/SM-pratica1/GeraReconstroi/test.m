N = 10000;
Ta = 0.001;

[x,t] = GeraSinal(N,Ta);

figure(1)
[X,f] = Espetro(x,Ta);
grid on