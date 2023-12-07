load('Guitar01.mat');
Ta = 1/fa;
[X,f] = Espetro(x,Ta);

H = zeros(length(f),1);
H((f>488.91) & (f<488.93)) = 1;
H((f>-488.93) & (f<-488.91)) = 1;
xf = H.*X;
[w,t] = Reconstroi(xf,f);
legend("Reconstrução Sinal");
w = real(w);
sound(w,fa)