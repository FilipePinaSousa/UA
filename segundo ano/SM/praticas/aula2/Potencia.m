function potencia = Potencia(x,Ta,T)
    maxIndex = T/Ta;

    x = x(:,1:maxIndex);

    potencia = x*x'/maxIndex;  % -> x' e a transposta 
end
