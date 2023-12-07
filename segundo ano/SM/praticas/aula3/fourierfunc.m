function [x,t] = fourierfunc (Ta,f,Np,a,b)
  N = round(Np/(f*Ta));
  t = (0:N-1)'*Ta;
  
  sumA = zeros(N,1);
  sumB = zeros(N,1);
  for k = 1 : length(a)
    sumA = sumA + a(k) * cos(2 * pi * (k-1) * f * t);
    sumB = sumB + b(k) * sin(2 * pi * (k-1) * f * t);
  end
  
  x = sumA + sumB;
  
end


%calcula os coeficientes diretamente 
% a partir de vetores a e b fornecidos como entrada,