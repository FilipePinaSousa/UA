load('Guitar03.mat');

Ta = 1/fa;
[X,f] = Espetro(x,Ta);

%% apagar abaixo 100 e acima dos 400
H = zeros(length(f),1);
H((f>100) & (f<400)) = 1;
H((f>-400) & (f<-100)) = 1;
X_final = H.*X;
[w,t] = Reconstroi(X_final,f);
legend("Reconstrução Sinal");
sound(w,fa)