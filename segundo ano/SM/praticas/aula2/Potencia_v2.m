function potencia = Potencia_v2(x,Ta,T)
    N = T / Ta;

    potencia = (x(1:N) * x(1:N)') / N;
end